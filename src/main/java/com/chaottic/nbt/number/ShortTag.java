package com.chaottic.nbt.number;

import java.io.DataInput;
import java.io.IOException;

public record ShortTag(short s) implements NumberTag {
    @Override
    public byte getAsByte() {
        return (byte) s;
    }

    @Override
    public short getAsShort() {
        return s;
    }

    @Override
    public int getAsInt() {
        return s;
    }

    @Override
    public long getAsLong() {
        return s;
    }

    @Override
    public float getAsFloat() {
        return s;
    }

    @Override
    public double getAsDouble() {
        return s;
    }

    public static ShortTag createShortTag(DataInput dataInput) throws IOException {
        return new ShortTag(dataInput.readShort());
    }
}
