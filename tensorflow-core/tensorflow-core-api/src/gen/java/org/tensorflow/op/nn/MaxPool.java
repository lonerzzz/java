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

package org.tensorflow.op.nn;

import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.Operator;
import org.tensorflow.types.TInt32;
import org.tensorflow.types.family.TNumber;

/**
 * Performs max pooling on the input.
 *
 * @param <T> data type for {@code output} output
 */
@Operator(
    group = "nn"
)
public final class MaxPool<T extends TNumber> extends RawOp implements Operand<T> {
  /**
   * The name of this op, as known by TensorFlow core engine
   */
  public static final String OP_NAME = "MaxPoolV2";

  private Output<T> output;

  private MaxPool(Operation operation) {
    super(operation);
    int outputIdx = 0;
    output = operation.output(outputIdx++);
  }

  /**
   * Factory method to create a class wrapping a new MaxPoolV2 operation.
   *
   * @param scope current scope
   * @param input 4-D input to pool over.
   * @param ksize The size of the window for each dimension of the input tensor.
   * @param strides The stride of the sliding window for each dimension of the
   * input tensor.
   * @param padding The type of padding algorithm to use.
   * @param options carries optional attribute values
   * @param <T> data type for {@code MaxPoolV2} output and operands
   * @return a new instance of MaxPool
   */
  @Endpoint(
      describeByClass = true
  )
  public static <T extends TNumber> MaxPool<T> create(Scope scope, Operand<T> input,
      Operand<TInt32> ksize, Operand<TInt32> strides, String padding, Options... options) {
    OperationBuilder opBuilder = scope.env().opBuilder("MaxPoolV2", scope.makeOpName("MaxPool"));
    opBuilder.addInput(input.asOutput());
    opBuilder.addInput(ksize.asOutput());
    opBuilder.addInput(strides.asOutput());
    opBuilder = scope.apply(opBuilder);
    opBuilder.setAttr("padding", padding);
    if (options != null) {
      for (Options opts : options) {
        if (opts.dataFormat != null) {
          opBuilder.setAttr("data_format", opts.dataFormat);
        }
      }
    }
    return new MaxPool<>(opBuilder.build());
  }

  /**
   * Sets the dataFormat option.
   *
   * @param dataFormat Specify the data format of the input and output data. With the
   * default format &quot;NHWC&quot;, the data is stored in the order of:
   * [batch, in_height, in_width, in_channels].
   * Alternatively, the format could be &quot;NCHW&quot;, the data storage order of:
   * [batch, in_channels, in_height, in_width].
   * @return this Options instance.
   */
  public static Options dataFormat(String dataFormat) {
    return new Options().dataFormat(dataFormat);
  }

  /**
   * Gets output.
   * The max pooled output tensor.
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
   * Optional attributes for {@link org.tensorflow.op.nn.MaxPool}
   */
  public static class Options {
    private String dataFormat;

    private Options() {
    }

    /**
     * Sets the dataFormat option.
     *
     * @param dataFormat Specify the data format of the input and output data. With the
     * default format &quot;NHWC&quot;, the data is stored in the order of:
     * [batch, in_height, in_width, in_channels].
     * Alternatively, the format could be &quot;NCHW&quot;, the data storage order of:
     * [batch, in_channels, in_height, in_width].
     * @return this Options instance.
     */
    public Options dataFormat(String dataFormat) {
      this.dataFormat = dataFormat;
      return this;
    }
  }
}
