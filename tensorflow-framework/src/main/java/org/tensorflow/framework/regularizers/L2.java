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
package org.tensorflow.framework.regularizers;

import org.tensorflow.op.Ops;

/**
 * A regularizer that applies a L2 (Ridge Regression) regularization penalty.
 *
 * <p>The L2 regularization penalty is computed as: <code>loss = l2 * reduceSum(square(x))</code>
 */
public class L2 extends L1L2 {

  /**
   * Create a regularizer that applies an L2 regularization penalty of {@link
   * #DEFAULT_REGULARIZATION_PENALTY}
   *
   * @param tf the TensorFlow Ops
   */
  public L2(Ops tf) {
    this(tf, DEFAULT_REGULARIZATION_PENALTY);
  }

  /**
   * Create a regularizer that applies an L1 regularization penalty
   *
   * @param tf the TensorFlow Ops
   * @param l2 the L2 regularization penalty
   * @throws IllegalArgumentException if the l2 regularization factor is NaN or is infinite.
   */
  public L2(Ops tf, float l2) {
    super(tf, 0f, l2);
  }
}
