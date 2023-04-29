package com.chaottic.nbt.number;

import java.io.DataInput;
import java.io.IOException;

public record FloatTag(float f) implements NumberTag {
    @Override
    public byte getAsByte() {
        return (byte) f;
    }

    @Override
    public short getAsShort() {
        return (short) f;
    }

    @Override
    public int getAsInt() {
        return (int) f;
    }

    @Override
    public long getAsLong() {
        return (long) f;
    }

    @Override
    public float getAsFloat() {
        return f;
    }

    @Override
    public double getAsDouble() {
        return f;
    }

    public static FloatTag createFloatTag(DataInput dataInput) throws IOException {
        return new FloatTag(dataInput.readFloat());
    }
}
