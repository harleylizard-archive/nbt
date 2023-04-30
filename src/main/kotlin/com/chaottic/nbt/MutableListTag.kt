package com.chaottic.nbt

class MutableListTag private constructor(override val list: MutableList<Tag>, opcode: Byte) : ListTag(list, opcode) {

	constructor(opcode: Byte) : this(arrayListOf(), opcode)
}