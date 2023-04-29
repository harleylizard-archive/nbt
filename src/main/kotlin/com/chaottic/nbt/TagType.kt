package com.chaottic.nbt

import com.chaottic.nbt.number.*
import java.io.DataInput

@FunctionalInterface
interface TagType<T: Tag> {

	fun createTag(dataInput: DataInput): T

	companion object {

		@JvmStatic
		fun getFromOpcode(opcode: Byte) = when (opcode) {
			Opcodes.byteTag -> ByteTag
			Opcodes.shortTag -> ShortTag
			Opcodes.intTag -> IntTag
			Opcodes.longTag -> LongTag
			Opcodes.floatTag -> FloatTag
			Opcodes.doubleTag -> DoubleTag
			Opcodes.stringTag -> StringTag
			Opcodes.listTag -> ListTag
			Opcodes.compoundTag -> CompoundTag
			else -> ByteTag
		}
	}
}