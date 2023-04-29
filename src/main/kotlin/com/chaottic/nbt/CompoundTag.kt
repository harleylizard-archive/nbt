package com.chaottic.nbt

import java.io.DataInput
import java.util.*

data class CompoundTag(private val map: Map<String, Tag>) : Tag {

	companion object : TagType<CompoundTag> {

		override fun createTag(dataInput: DataInput): CompoundTag {
			val map = HashMap<String, Tag>()

			var opcode: Byte
			while (dataInput.readByte().also { opcode = it } != 0.toByte()) {
				map[dataInput.readUTF()] = TagType.getFromOpcode(opcode).createTag(dataInput)
			}

			return CompoundTag(Collections.unmodifiableMap(map))
		}
	}
}
