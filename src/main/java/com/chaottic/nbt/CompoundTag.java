package com.chaottic.nbt;

import com.chaottic.nbt.number.NumberTag;
import it.unimi.dsi.fastutil.bytes.ByteList;
import it.unimi.dsi.fastutil.doubles.DoubleList;
import it.unimi.dsi.fastutil.floats.FloatList;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.longs.LongList;
import it.unimi.dsi.fastutil.shorts.ShortList;

import java.io.DataInput;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public sealed class CompoundTag implements Tag permits MutableCompoundTag {
    protected final Map<String, Tag> map;

    protected CompoundTag(Map<String, Tag> map) {
        this.map = map;
    }

    public byte getByte(String name) {
        if (map.containsKey(name) && map.get(name) instanceof NumberTag numberTag) {
            return numberTag.getAsByte();
        }
        return 0;
    }

    public short getShort(String name) {
        if (map.containsKey(name) && map.get(name) instanceof NumberTag numberTag) {
            return numberTag.getAsShort();
        }
        return 0;
    }

    public int getInt(String name) {
        if (map.containsKey(name) && map.get(name) instanceof NumberTag numberTag) {
            return numberTag.getAsInt();
        }
        return 0;
    }

    public long getLong(String name) {
        if (map.containsKey(name) && map.get(name) instanceof NumberTag numberTag) {
            return numberTag.getAsLong();
        }
        return 0L;
    }

    public float getFloat(String name) {
        if (map.containsKey(name) && map.get(name) instanceof NumberTag numberTag) {
            return numberTag.getAsFloat();
        }
        return 0.0F;
    }

    public double getDouble(String name) {
        if (map.containsKey(name) && map.get(name) instanceof NumberTag numberTag) {
            return numberTag.getAsDouble();
        }
        return 0.0D;
    }

    public String getString(String name) {
        if (map.containsKey(name) && map.get(name) instanceof StringTag stringTag) {
            return stringTag.s();
        }
        return "";
    }

    public ByteList getByteList(String name) {
        if (map.containsKey(name) && map.get(name) instanceof ListTag listTag) {
            return listTag.asByteList();
        }
        return ByteList.of();
    }

    public ShortList getShortList(String name) {
        if (map.containsKey(name) && map.get(name) instanceof ListTag listTag) {
            return listTag.asShortList();
        }
        return ShortList.of();
    }

    public IntList getIntList(String name) {
        if (map.containsKey(name) && map.get(name) instanceof ListTag listTag) {
            return listTag.asIntList();
        }
        return IntList.of();
    }

    public LongList getLongList(String name) {
        if (map.containsKey(name) && map.get(name) instanceof ListTag listTag) {
            return listTag.asLongList();
        }
        return LongList.of();
    }

    public FloatList getFloatList(String name) {
        if (map.containsKey(name) && map.get(name) instanceof ListTag listTag) {
            return listTag.asFloatList();
        }
        return FloatList.of();
    }

    public DoubleList getDoubleList(String name) {
        if (map.containsKey(name) && map.get(name) instanceof ListTag listTag) {
            return listTag.asDoubleList();
        }
        return DoubleList.of();
    }

    public static CompoundTag createCompoundTag(DataInput dataInput) throws IOException {
        var map = new HashMap<String, Tag>();

        byte opcode;
        while ((opcode = dataInput.readByte()) != 0) {
            map.put(dataInput.readUTF(), TagTypes.fromOpcode(opcode).createTag(dataInput));
        }

        return new CompoundTag(Collections.unmodifiableMap(map));
    }
}
