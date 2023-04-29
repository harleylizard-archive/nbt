package com.chaottic.nbt;

import java.util.ArrayList;

public final class MutableListTag extends ListTag {

    public MutableListTag(byte opcode) {
        super(new ArrayList<>(), opcode);
    }
}
