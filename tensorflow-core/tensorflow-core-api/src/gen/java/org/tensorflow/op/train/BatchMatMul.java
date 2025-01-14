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

package org.tensorflow.op.train;

import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.Operator;
import org.tensorflow.types.family.TType;

/**
 * Multiplies slices of two tensors in batches.
 * Multiplies all slices of {@code Tensor} {@code x} and {@code y} (each slice can be
 * viewed as an element of a batch), and arranges the individual results
 * in a single output tensor of the same batch size. Each of the
 * individual slices can optionally be adjointed (to adjoint a matrix
 * means to transpose and conjugate it) before multiplication by setting
 * the {@code adj_x} or {@code adj_y} flag to {@code True}, which are by default {@code False}.
 * <p>The input tensors {@code x} and {@code y} are 2-D or higher with shape {@code [..., r_x, c_x]}
 * and {@code [..., r_y, c_y]}.
 * <p>The output tensor is 2-D or higher with shape {@code [..., r_o, c_o]}, where:
 * <pre>
 * r_o = c_x if adj_x else r_x
 * c_o = r_y if adj_y else c_y
 * </pre>
 * <p>It is computed as:
 * <pre>
 * output[..., :, :] = matrix(x[..., :, :]) * matrix(y[..., :, :])
 * </pre>
 * <p><em>NOTE</em>: {@code train.BatchMatMul} supports broadcasting in the batch dimensions. More
 * about broadcasting
 *  <a href="http://docs.scipy.org/doc/numpy/user/basics.broadcasting.html">here</a> .
 *
 * @param <T> data type for {@code output} output
 */
@Operator(
    group = "train"
)
public final class BatchMatMul<T extends TType> extends RawOp implements Operand<T> {
  /**
   * The name of this op, as known by TensorFlow core engine
   */
  public static final String OP_NAME = "BatchMatMulV2";

  private Output<T> output;

  private BatchMatMul(Operation operation) {
    super(operation);
    int outputIdx = 0;
    output = operation.output(outputIdx++);
  }

  /**
   * Factory method to create a class wrapping a new BatchMatMulV2 operation.
   *
   * @param scope current scope
   * @param x 2-D or higher with shape {@code [..., r_x, c_x]}.
   * @param y 2-D or higher with shape {@code [..., r_y, c_y]}.
   * @param options carries optional attribute values
   * @param <T> data type for {@code BatchMatMulV2} output and operands
   * @return a new instance of BatchMatMul
   */
  @Endpoint(
      describeByClass = true
  )
  public static <T extends TType> BatchMatMul<T> create(Scope scope, Operand<T> x, Operand<T> y,
      Options... options) {
    OperationBuilder opBuilder = scope.env().opBuilder("BatchMatMulV2", scope.makeOpName("BatchMatMul"));
    opBuilder.addInput(x.asOutput());
    opBuilder.addInput(y.asOutput());
    opBuilder = scope.apply(opBuilder);
    if (options != null) {
      for (Options opts : options) {
        if (opts.adjX != null) {
          opBuilder.setAttr("adj_x", opts.adjX);
        }
        if (opts.adjY != null) {
          opBuilder.setAttr("adj_y", opts.adjY);
        }
      }
    }
    return new BatchMatMul<>(opBuilder.build());
  }

  /**
   * Sets the adjX option.
   *
   * @param adjX If {@code True}, adjoint the slices of {@code x}. Defaults to {@code False}.
   * @return this Options instance.
   */
  public static Options adjX(Boolean adjX) {
    return new Options().adjX(adjX);
  }

  /**
   * Sets the adjY option.
   *
   * @param adjY If {@code True}, adjoint the slices of {@code y}. Defaults to {@code False}.
   * @return this Options instance.
   */
  public static Options adjY(Boolean adjY) {
    return new Options().adjY(adjY);
  }

  /**
   * Gets output.
   * 3-D or higher with shape {@code [..., r_o, c_o]}
   * @return output.
   */
  public Output<T> output() {
    return output;
  }

  @Override
  public Output<T> asOutput() {
    return output;
  }

  /**
   * Optional attributes for {@link org.tensorflow.op.train.BatchMatMul}
   */
  public static class Options {
    private Boolean adjX;

    private Boolean adjY;

    private Options() {
    }

    /**
     * Sets the adjX option.
     *
     * @param adjX If {@code True}, adjoint the slices of {@code x}. Defaults to {@code False}.
     * @return this Options instance.
     */
    public Options adjX(Boolean adjX) {
      this.adjX = adjX;
      return this;
    }

    /**
     * Sets the adjY option.
     *
     * @param adjY If {@code True}, adjoint the slices of {@code y}. Defaults to {@code False}.
     * @return this Options instance.
     */
    public Options adjY(Boolean adjY) {
      this.adjY = adjY;
      return this;
    }
  }
}
