package com.chaottic.nbt;

import com.chaottic.nbt.number.*;

public final class TagTypes {
    public static final TagType<ByteTag> BYTE = ByteTag::createByteTag;
    public static final TagType<ShortTag> SHORT = ShortTag::createShortTag;
    public static final TagType<IntTag> INT = IntTag::createIntTag;
    public static final TagType<LongTag> LONG = LongTag::createLongTag;
    public static final TagType<FloatTag> FLOAT = FloatTag::createFloatTag;
    public static final TagType<DoubleTag> DOUBLE = DoubleTag::createDoubleTag;
    public static final TagType<StringTag> STRING = StringTag::createStringTag;
    public static final TagType<ListTag> LIST = ListTag::createListTag;
    public static final TagType<CompoundTag> COMPOUND = CompoundTag::createCompoundTag;

    private TagTypes() {}

    public static TagType<? extends Tag> fromOpcode(byte b) {
        return switch (b) {
            case Opcodes.BYTE_TAG -> BYTE;
            case Opcodes.SHORT_TAG -> SHORT;
            case Opcodes.INT_TAG -> INT;
            case Opcodes.LONG_TAG -> LONG;
            case Opcodes.FLOAT_TAG -> FLOAT;
            case Opcodes.DOUBLE_TAG -> DOUBLE;
            case Opcodes.STRING_TAG -> STRING;
            case Opcodes.LIST_TAG -> LIST;
            case Opcodes.COMPOUND_TAG -> COMPOUND;

            default -> throw new IllegalStateException("Unexpected value: %d".formatted(b));
        };
    }
}
