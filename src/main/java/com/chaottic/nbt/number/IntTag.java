package com.chaottic.nbt.number;

import java.io.DataInput;
import java.io.IOException;

public record IntTag(int i) implements NumberTag {
    @Override
    public byte getAsByte() {
        return (byte) i;
    }

    @Override
    public short getAsShort() {
        return (short) i;
    }

    @Override
    public int getAsInt() {
        return i;
    }

    @Override
    public long getAsLong() {
        return i;
    }

    @Override
    public float getAsFloat() {
        return i;
    }

    @Override
    public double getAsDouble() {
        return i;
    }

    public static IntTag createIntTag(DataInput dataInput) throws IOException {
        return new IntTag(dataInput.readInt());
    }
}
