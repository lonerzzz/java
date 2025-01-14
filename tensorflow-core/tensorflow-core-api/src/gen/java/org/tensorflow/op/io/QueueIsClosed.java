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

package org.tensorflow.op.io;

import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.Operator;
import org.tensorflow.types.TBool;
import org.tensorflow.types.family.TType;

/**
 * Returns true if queue is closed.
 * This operation returns true if the queue is closed and false if the queue
 * is open.
 */
@Operator(
    group = "io"
)
public final class QueueIsClosed extends RawOp implements Operand<TBool> {
  /**
   * The name of this op, as known by TensorFlow core engine
   */
  public static final String OP_NAME = "QueueIsClosedV2";

  private Output<TBool> isClosed;

  private QueueIsClosed(Operation operation) {
    super(operation);
    int outputIdx = 0;
    isClosed = operation.output(outputIdx++);
  }

  /**
   * Factory method to create a class wrapping a new QueueIsClosedV2 operation.
   *
   * @param scope current scope
   * @param handle The handle to a queue.
   * @return a new instance of QueueIsClosed
   */
  @Endpoint(
      describeByClass = true
  )
  public static QueueIsClosed create(Scope scope, Operand<? extends TType> handle) {
    OperationBuilder opBuilder = scope.env().opBuilder("QueueIsClosedV2", scope.makeOpName("QueueIsClosed"));
    opBuilder.addInput(handle.asOutput());
    opBuilder = scope.apply(opBuilder);
    return new QueueIsClosed(opBuilder.build());
  }

  /**
   * Gets isClosed.
   *
   * @return isClosed.
   */
  public Output<TBool> isClosed() {
    return isClosed;
  }

  @Override
  public Output<TBool> asOutput() {
    return isClosed;
  }
}
