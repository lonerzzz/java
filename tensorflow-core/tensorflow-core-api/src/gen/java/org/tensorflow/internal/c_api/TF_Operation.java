// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.tensorflow.internal.c_api;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.tensorflow.internal.c_api.global.tensorflow.*;


// Operation that has been added to the graph. Valid until the graph is
// deleted -- in particular adding a new operation to the graph does not
// invalidate old TF_Operation* pointers.
@Opaque @Properties(inherit = org.tensorflow.internal.c_api.presets.tensorflow.class)
public class TF_Operation extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public TF_Operation() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TF_Operation(Pointer p) { super(p); }
}
