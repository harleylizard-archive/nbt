package com.chaottic.nbt.number;

import com.chaottic.nbt.Tag;

public sealed interface NumberTag extends Tag permits ByteTag, DoubleTag, FloatTag, IntTag, LongTag, ShortTag {

    byte getAsByte();

    short getAsShort();

    int getAsInt();

    long getAsLong();

    float getAsFloat();

    double getAsDouble();
}
