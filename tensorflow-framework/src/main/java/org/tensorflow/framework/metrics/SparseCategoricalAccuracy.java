/* Copyright 2020 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
=======================================================================*/
package org.tensorflow.framework.metrics;

import org.tensorflow.Operand;
import org.tensorflow.framework.metrics.impl.LossMetric;
import org.tensorflow.framework.metrics.impl.MeanMetricWrapper;
import org.tensorflow.ndarray.Shape;
import org.tensorflow.op.Ops;
import org.tensorflow.op.core.Squeeze;
import org.tensorflow.op.math.Equal;
import org.tensorflow.types.TInt64;
import org.tensorflow.types.family.TNumber;

import java.util.Collections;

import static org.tensorflow.framework.utils.CastHelper.cast;

/**
 * Calculates how often predictions matches integer labels.
 *
 * <p>You can provide logits of classes as {@code predictions}, since argmax of logits and
 * probabilities are same.
 *
 * <p>This metric creates two local variables, `total` and `count` that are used to compute the
 * frequency with which {@code predictions} matches {@code labels}. This frequency is
 * ultimately returned as `sparse categorical accuracy`: an idempotent operation that simply divides
 * `total` by `count`.
 *
 * <p>If `sample_weight` is `None`, weights default to 1. Use `sample_weight` of 0 to mask values.'
 *
 * <p>Usage:
 *
 * <pre>
 * SparseCategoricalAccuracy m = new org.tensorflow.framework.metrcis.SparseCategoricalAccuracy();
 * m.update_state(tf.constant(new float[][] {{2}, {1}},
 *     tf.constant(new float[][] {{0.1f, 0.9f, 0.8f}, [{0.05f, 0.95f, 0f}});
 * Operand&lt;TFloat32&gt; result = m.result();
 * System.out.println(result.data().getFloat());
 * 0.5
 * </pre>
 *
 * <pre>
 * m.reset_states()
 * m.update_state(
 *     tf.constant(new float[][] {{2}, {1}},
 *     tf.constant(new float[][] {{0.1f, 0.9f, 0.8f}, {0.05f, 0.95f, 0f}},
 *     tf.constant(new float[] {0.7f, 0.3f});
 * result = m.result();
 * System.out.println(result.data().getFloat());
 * 0.3
 * </pre>
 *
 * @param <T> The data type for the metric result
 */
public class SparseCategoricalAccuracy<T extends TNumber> extends MeanMetricWrapper<T>
    implements LossMetric<T> {

  /**
   * Creates a SparseCategoricalAccuracy metric, using name of {@link Class#getSimpleName()}.
   *
   * @param tf the TensorFlow Ops
   * @param seed the seed for random number generation. An initializer created with a given seed
   *     will always produce the same random tensor for a given shape and data type.
   * @param type The data type for the metric result
   */
  public SparseCategoricalAccuracy(Ops tf, long seed, Class<T> type) {
    this(tf, null, seed, type);
  }

  /**
   * Creates a SparseCategoricalAccuracy metric.
   *
   * @param tf the TensorFlow Ops
   * @param name the name of the metric, if null use {@link Class#getSimpleName()}
   * @param seed the seed for random number generation. An initializer created with a given seed
   *     will always produce the same random tensor for a given shape and data type.
   * @param type the type of the metric result.
   */
  public SparseCategoricalAccuracy(Ops tf, String name, long seed, Class<T> type) {
    super(tf, name, seed, type);
    super.setLoss(this);
  }

  /**
   * Calculates how often predictions matches integer labels.
   *
   * @param labels Integer ground truth values.
   * @param predictions the predictions
   * @return Sparse categorical accuracy values.
   */
  @Override
  public Operand<T> call(
      Operand<? extends TNumber> labels, Operand<? extends TNumber> predictions) {

    Operand<T> tLabels = cast(getTF(), labels, getResultType());
    Operand<T> tPredictions = cast(getTF(), predictions, getResultType());
    Shape predShape = predictions.asOutput().shape();
    Shape labelsShape = labels.asOutput().shape();
    long predictionsRank = predShape.numDimensions();
    long labelsRank = labelsShape.numDimensions();

    // If the shape of labels is (num_samples, 1), squeeze to (num_samples,)
    if (predictionsRank != Shape.UNKNOWN_SIZE
        && labelsRank != Shape.UNKNOWN_SIZE
        && labelsShape.size((int) labelsRank - 1) == 1) {
      tLabels = getTF().squeeze(tLabels, Squeeze.axis(Collections.singletonList(labelsRank - 1L)));
    }
    Operand<T> argMaxPred =
        cast(
            getTF(),
            getTF().math.argMax(tPredictions, getTF().constant(-1L), TInt64.class),
            getResultType());

    Equal equals = getTF().math.equal(tLabels, argMaxPred);
    return getTF().dtypes.cast(equals, getResultType());
  }
}
