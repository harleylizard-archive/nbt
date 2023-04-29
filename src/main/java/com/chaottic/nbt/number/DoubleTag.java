package com.chaottic.nbt.number;

import java.io.DataInput;
import java.io.IOException;

public record DoubleTag(double d) implements NumberTag {
    @Override
    public byte getAsByte() {
        return (byte) d;
    }

    @Override
    public short getAsShort() {
        return (short) d;
    }

    @Override
    public int getAsInt() {
        return (int) d;
    }

    @Override
    public long getAsLong() {
        return (long) d;
    }

    @Override
    public float getAsFloat() {
        return (float) d;
    }

    @Override
    public double getAsDouble() {
        return d;
    }

    public static DoubleTag createDoubleTag(DataInput dataInput) throws IOException {
        return new DoubleTag(dataInput.readDouble());
    }
}
