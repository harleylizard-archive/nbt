package com.chaottic.nbt

import com.chaottic.nbt.number.NumberTag
import java.io.DataInput
import java.util.*

open class CompoundTag protected constructor(protected open val map: Map<String, Tag>) : Tag {

	// TODO:: Shrink
	fun getByte(name: String): Byte {
		if (map.containsKey(name)) {
			val tag = map[name]

			if (tag is NumberTag) {
				return tag.asByte()
			}
		}

		return 0
	}

	fun getShort(name: String): Short {
		if (map.containsKey(name)) {
			val tag = map[name]

			if (tag is NumberTag) {
				return tag.asShort()
			}
		}

		return 0
	}

	fun getInt(name: String): Int {
		if (map.containsKey(name)) {
			val tag = map[name]

			if (tag is NumberTag) {
				return tag.asInt()
			}
		}

		return 0
	}

	fun getLong(name: String): Long {
		if (map.containsKey(name)) {
			val tag = map[name]

			if (tag is NumberTag) {
				return tag.asLong()
			}
		}

		return 0L
	}

	fun getFloat(name: String): Float {
		if (map.containsKey(name)) {
			val tag = map[name]

			if (tag is NumberTag) {
				return tag.asFloat()
			}
		}

		return 0.0F
	}

	fun getDouble(name: String): Double {
		if (map.containsKey(name)) {
			val tag = map[name]

			if (tag is NumberTag) {
				return tag.asDouble()
			}
		}

		return 0.0
	}

	fun getString(name: String): String {
		if (map.containsKey(name)) {
			val tag = map[name]

			if (tag is StringTag) {
				return tag.s
			}
		}

		return ""
	}

	fun getListTag(name: String, opcode: Byte): ListTag {
		if (map.containsKey(name)) {
			val tag = map[name]

			if (tag is ListTag && tag.opcode == opcode) {
				return tag
			}
		}

		return ListTag.empty
	}

	fun getCompoundTag(name: String): CompoundTag {
		if (map.containsKey(name)) {
			val tag = map[name]

			if (tag is CompoundTag) {
				return tag
			}
		}

		return empty
	}

	companion object : TagType<CompoundTag> {
		@JvmStatic
		private val empty = CompoundTag(emptyMap())

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
