package com.chaottic.nbt;

import java.io.DataInput;
import java.io.IOException;

public record StringTag(String s) implements Tag {

    public static StringTag createStringTag(DataInput dataInput) throws IOException {
        return new StringTag(dataInput.readUTF());
    }
}
