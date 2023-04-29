package com.chaottic.nbt.number;

import java.io.DataInput;
import java.io.IOException;

public record LongTag(long l) implements NumberTag {
    @Override
    public byte getAsByte() {
        return (byte) l;
    }

    @Override
    public short getAsShort() {
        return (short) l;
    }

    @Override
    public int getAsInt() {
        return (int) l;
    }

    @Override
    public long getAsLong() {
        return l;
    }

    @Override
    public float getAsFloat() {
        return l;
    }

    @Override
    public double getAsDouble() {
        return l;
    }

    public static LongTag createLongTag(DataInput dataInput) throws IOException {
        return new LongTag(dataInput.readLong());
    }
}
