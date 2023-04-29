package com.chaottic.nbt.number;

import java.io.DataInput;
import java.io.IOException;

public record ByteTag(byte b) implements NumberTag {
    @Override
    public byte getAsByte() {
        return b;
    }

    @Override
    public short getAsShort() {
        return b;
    }

    @Override
    public int getAsInt() {
        return b;
    }

    @Override
    public long getAsLong() {
        return b;
    }

    @Override
    public float getAsFloat() {
        return b;
    }

    @Override
    public double getAsDouble() {
        return b;
    }

    public static ByteTag createByteTag(DataInput dataInput) throws IOException {
        return new ByteTag(dataInput.readByte());
    }
}
