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

package org.tensorflow.op.data;

import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.types.TString;
import org.tensorflow.types.family.TType;

/**
 * Returns a serialized GraphDef representing {@code input_dataset}.
 * Returns a graph representation for {@code input_dataset}.
 */
public final class DatasetToGraph extends RawOp implements Operand<TString> {
  /**
   * The name of this op, as known by TensorFlow core engine
   */
  public static final String OP_NAME = "DatasetToGraphV2";

  private Output<TString> graph;

  private DatasetToGraph(Operation operation) {
    super(operation);
    int outputIdx = 0;
    graph = operation.output(outputIdx++);
  }

  /**
   * Factory method to create a class wrapping a new DatasetToGraphV2 operation.
   *
   * @param scope current scope
   * @param inputDataset A variant tensor representing the dataset to return the graph representation for.
   * @param options carries optional attribute values
   * @return a new instance of DatasetToGraph
   */
  @Endpoint(
      describeByClass = true
  )
  public static DatasetToGraph create(Scope scope, Operand<? extends TType> inputDataset,
      Options... options) {
    OperationBuilder opBuilder = scope.env().opBuilder("DatasetToGraphV2", scope.makeOpName("DatasetToGraph"));
    opBuilder.addInput(inputDataset.asOutput());
    opBuilder = scope.apply(opBuilder);
    if (options != null) {
      for (Options opts : options) {
        if (opts.externalStatePolicy != null) {
          opBuilder.setAttr("external_state_policy", opts.externalStatePolicy);
        }
        if (opts.stripDeviceAssignment != null) {
          opBuilder.setAttr("strip_device_assignment", opts.stripDeviceAssignment);
        }
      }
    }
    return new DatasetToGraph(opBuilder.build());
  }

  /**
   * Sets the externalStatePolicy option.
   *
   * @param externalStatePolicy the externalStatePolicy option
   * @return this Options instance.
   */
  public static Options externalStatePolicy(Long externalStatePolicy) {
    return new Options().externalStatePolicy(externalStatePolicy);
  }

  /**
   * Sets the stripDeviceAssignment option.
   *
   * @param stripDeviceAssignment the stripDeviceAssignment option
   * @return this Options instance.
   */
  public static Options stripDeviceAssignment(Boolean stripDeviceAssignment) {
    return new Options().stripDeviceAssignment(stripDeviceAssignment);
  }

  /**
   * Gets graph.
   * The graph representation of the dataset (as serialized GraphDef).
   * @return graph.
   */
  public Output<TString> graph() {
    return graph;
  }

  @Override
  public Output<TString> asOutput() {
    return graph;
  }

  /**
   * Optional attributes for {@link org.tensorflow.op.data.DatasetToGraph}
   */
  public static class Options {
    private Long externalStatePolicy;

    private Boolean stripDeviceAssignment;

    private Options() {
    }

    /**
     * Sets the externalStatePolicy option.
     *
     * @param externalStatePolicy the externalStatePolicy option
     * @return this Options instance.
     */
    public Options externalStatePolicy(Long externalStatePolicy) {
      this.externalStatePolicy = externalStatePolicy;
      return this;
    }

    /**
     * Sets the stripDeviceAssignment option.
     *
     * @param stripDeviceAssignment the stripDeviceAssignment option
     * @return this Options instance.
     */
    public Options stripDeviceAssignment(Boolean stripDeviceAssignment) {
      this.stripDeviceAssignment = stripDeviceAssignment;
      return this;
    }
  }
}
