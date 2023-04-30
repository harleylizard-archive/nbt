package com.chaottic.nbt

class MutableListTag private constructor(override val list: MutableList<Tag>, opcode: Byte) : ListTag(list, opcode) {

	constructor(opcode: Byte) : this(arrayListOf(), opcode)

	operator fun set(i: Int, tag: Tag) {
		list[i] = tag
	}
}