package com.chaottic.nbt;

import java.io.DataInput;
import java.io.IOException;

@FunctionalInterface
public interface TagType<T extends Tag> {

    T createTag(DataInput dataInput) throws IOException;
}
