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
import org.tensorflow.types.family.TNumber;

/**
 * Returns element-wise integer closest to x.
 * If the result is midway between two representable values,
 * the even representable is chosen.
 * For example:
 * <pre>
 * rint(-1.5) ==&gt; -2.0
 * rint(0.5000001) ==&gt; 1.0
 * rint([-1.7, -1.5, -0.2, 0.2, 1.5, 1.7, 2.0]) ==&gt; [-2., -2., -0., 0., 2., 2., 2.]
 * </pre>
 *
 * @param <T> data type for {@code y} output
 */
@Operator(
    group = "math"
)
public final class Rint<T extends TNumber> extends RawOp implements Operand<T> {
  /**
   * The name of this op, as known by TensorFlow core engine
   */
  public static final String OP_NAME = "Rint";

  private Output<T> y;

  private Rint(Operation operation) {
    super(operation);
    int outputIdx = 0;
    y = operation.output(outputIdx++);
  }

  /**
   * Factory method to create a class wrapping a new Rint operation.
   *
   * @param scope current scope
   * @param x the x value
   * @param <T> data type for {@code Rint} output and operands
   * @return a new instance of Rint
   */
  @Endpoint(
      describeByClass = true
  )
  public static <T extends TNumber> Rint<T> create(Scope scope, Operand<T> x) {
    OperationBuilder opBuilder = scope.env().opBuilder("Rint", scope.makeOpName("Rint"));
    opBuilder.addInput(x.asOutput());
    opBuilder = scope.apply(opBuilder);
    return new Rint<>(opBuilder.build());
  }

  /**
   * Gets y.
   *
   * @return y.
   */
  public Output<T> y() {
    return y;
  }

  @Override
  public Output<T> asOutput() {
    return y;
  }
}
