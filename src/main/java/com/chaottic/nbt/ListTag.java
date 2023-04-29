package com.chaottic.nbt;

import com.chaottic.nbt.number.*;
import it.unimi.dsi.fastutil.bytes.ByteArrayList;
import it.unimi.dsi.fastutil.bytes.ByteList;
import it.unimi.dsi.fastutil.bytes.ByteLists;
import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import it.unimi.dsi.fastutil.doubles.DoubleList;
import it.unimi.dsi.fastutil.doubles.DoubleLists;
import it.unimi.dsi.fastutil.floats.FloatArrayList;
import it.unimi.dsi.fastutil.floats.FloatList;
import it.unimi.dsi.fastutil.floats.FloatLists;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.ints.IntLists;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongList;
import it.unimi.dsi.fastutil.longs.LongLists;
import it.unimi.dsi.fastutil.shorts.ShortArrayList;
import it.unimi.dsi.fastutil.shorts.ShortList;
import it.unimi.dsi.fastutil.shorts.ShortLists;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public sealed class ListTag implements Tag permits MutableListTag {
    private static final ListTag EMPTY = new ListTag(List.of(), (byte) 0);

    private final List<Tag> list;

    private final byte opcode;

    protected ListTag(List<Tag> list, byte opcode) {
        this.list = list;
        this.opcode = opcode;
    }

    public ByteList asByteList() {
        if (opcode == Opcodes.BYTE_TAG) {
            var byteList = new ByteArrayList(list.size());
            list.forEach(tag -> byteList.add(((ByteTag) tag).b()));
            return ByteLists.unmodifiable(byteList);
        }
        return ByteList.of();
    }

    public ShortList asShortList() {
        if (opcode == Opcodes.SHORT_TAG) {
            var shortList = new ShortArrayList(list.size());
            list.forEach(tag -> shortList.add(((ShortTag) tag).s()));
            return ShortLists.unmodifiable(shortList);
        }
        return ShortList.of();
    }

    public IntList asIntList() {
        if (opcode == Opcodes.INT_TAG) {
            var intList = new IntArrayList(list.size());
            list.forEach(tag -> intList.add(((IntTag) tag).i()));
            return IntLists.unmodifiable(intList);
        }
        return IntList.of();
    }

    public LongList asLongList() {
        if (opcode == Opcodes.LONG_TAG) {
            var longList = new LongArrayList(list.size());
            list.forEach(tag -> longList.add(((LongTag) tag).l()));
            return LongLists.unmodifiable(longList);
        }
        return LongList.of();
    }

    public FloatList asFloatList() {
        if (opcode == Opcodes.FLOAT_TAG) {
            var floatList = new FloatArrayList(list.size());
            list.forEach(tag -> floatList.add(((FloatTag) tag).f()));
            return FloatLists.unmodifiable(floatList);
        }
        return FloatList.of();
    }

    public DoubleList asDoubleList() {
        if (opcode == Opcodes.DOUBLE_TAG) {
            var doubleList = new DoubleArrayList(list.size());
            list.forEach(tag -> doubleList.add(((DoubleTag) tag).d()));
            return DoubleLists.unmodifiable(doubleList);
        }
        return DoubleList.of();
    }

    public static ListTag createListTag(DataInput dataInput) throws IOException {
        var opcode = dataInput.readByte();
        var size = dataInput.readInt();

        if (opcode == 0) {
            return EMPTY;
        }

        var list = new ArrayList<Tag>(size);

        var type = TagTypes.fromOpcode(opcode);

        for (var i = 0; i < size; i++) {
            list.add(type.createTag(dataInput));
        }

        return new ListTag(Collections.unmodifiableList(list), opcode);
    }
}
