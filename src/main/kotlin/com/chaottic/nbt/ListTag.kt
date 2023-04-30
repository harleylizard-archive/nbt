package com.chaottic.nbt

import java.io.DataInput
import java.util.*
import kotlin.collections.ArrayList

open class ListTag protected constructor(protected open val list: List<Tag>, val opcode: Byte) : Tag, Iterable<Tag> {
	val size; get() = list.size

	operator fun get(i: Int) = list[i]

	override fun iterator() = list.iterator()

	companion object : TagType<ListTag> {
		@JvmStatic
		internal val empty = ListTag(emptyList(), 0)

		override fun createTag(dataInput: DataInput): ListTag {
			val opcode = dataInput.readByte()
			val size = dataInput.readInt()

			if (opcode == 0.toByte()) {
				return empty
			}

			val list = ArrayList<Tag>(size)
			val type = TagType.getFromOpcode(opcode)

			for (i in 0 until size) {
				list.add(type.createTag(dataInput))
			}

			return ListTag(Collections.unmodifiableList(list), opcode)
		}
	}
}
