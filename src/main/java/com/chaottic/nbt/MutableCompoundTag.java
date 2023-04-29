package com.chaottic.nbt;

import com.chaottic.nbt.number.*;

import java.util.HashMap;

public final class MutableCompoundTag extends CompoundTag {

    public MutableCompoundTag() {
        super(new HashMap<>());
    }

    public void setByte(String name, byte b) {
        map.put(name, new ByteTag(b));
    }

    public void setShort(String name, short s) {
        map.put(name, new ShortTag(s));
    }

    public void setInt(String name, int i) {
        map.put(name, new IntTag(i));
    }

    public void setLong(String name, long l) {
        map.put(name, new LongTag(l));
    }

    public void setFloat(String name, float f) {
        map.put(name, new FloatTag(f));
    }

    public void setDouble(String name, double d) {
        map.put(name, new DoubleTag(d));
    }

    public void setString(String name, String s) {
        map.put(name, new StringTag(s));
    }

    public void setTag(String name, Tag tag) {
        map.put(name, tag);
    }
}
