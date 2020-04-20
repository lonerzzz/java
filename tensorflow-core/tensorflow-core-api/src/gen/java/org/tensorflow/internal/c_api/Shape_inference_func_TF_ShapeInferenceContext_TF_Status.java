// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.tensorflow.internal.c_api;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.tensorflow.internal.c_api.global.tensorflow.*;


// Sets the shape inference function for the op.
@Properties(inherit = org.tensorflow.internal.c_api.presets.tensorflow.class)
public class Shape_inference_func_TF_ShapeInferenceContext_TF_Status extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    Shape_inference_func_TF_ShapeInferenceContext_TF_Status(Pointer p) { super(p); }
    protected Shape_inference_func_TF_ShapeInferenceContext_TF_Status() { allocate(); }
    private native void allocate();
    public native void call(TF_ShapeInferenceContext ctx,
                                 TF_Status status);
}
