package com.chaottic.nbt

class MutableListTag(override val list: MutableList<Tag>, opcode: Byte) : ListTag(list, opcode) {

	constructor(opcode: Byte) : this(arrayListOf(), opcode)
}