/* Copyright 2018 The TensorFlow Authors. All Rights Reserved.

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

// This class has been generated, DO NOT EDIT!

package org.tensorflow.op.math;

import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.Operator;
import org.tensorflow.types.TBool;
import org.tensorflow.types.family.TNumber;

/**
 * Returns which elements of x are Inf.
 * {@literal @}compatibility(numpy)<br>
 * Equivalent to np.isinf
 * <br>{@literal @}end_compatibility
 * <p>Example:
 * <pre>
 * x = tf.constant([5.0, np.inf, 6.8, np.inf])
 * tf.math.is_inf(x) ==&gt; [False, True, False, True]
 * </pre>
 */
@Operator(
    group = "math"
)
public final class IsInf extends RawOp implements Operand<TBool> {
  /**
   * The name of this op, as known by TensorFlow core engine
   */
  public static final String OP_NAME = "IsInf";

  private Output<TBool> y;

  private IsInf(Operation operation) {
    super(operation);
    int outputIdx = 0;
    y = operation.output(outputIdx++);
  }

  /**
   * Factory method to create a class wrapping a new IsInf operation.
   *
   * @param scope current scope
   * @param x the x value
   * @return a new instance of IsInf
   */
  @Endpoint(
      describeByClass = true
  )
  public static IsInf create(Scope scope, Operand<? extends TNumber> x) {
    OperationBuilder opBuilder = scope.env().opBuilder("IsInf", scope.makeOpName("IsInf"));
    opBuilder.addInput(x.asOutput());
    opBuilder = scope.apply(opBuilder);
    return new IsInf(opBuilder.build());
  }

  /**
   * Gets y.
   *
   * @return y.
   */
  public Output<TBool> y() {
    return y;
  }

  @Override
  public Output<TBool> asOutput() {
    return y;
  }
}
