package com.chaottic.nbt

import com.chaottic.nbt.number.*

class MutableCompoundTag private constructor(override val map: MutableMap<String, Tag>) : CompoundTag(map) {

	constructor() : this(hashMapOf())

	@JvmSynthetic
	operator fun set(name: String, b: Byte) {
		map[name] = ByteTag(b)
	}

	@JvmSynthetic
	operator fun set(name: String, s: Short) {
		map[name] = ShortTag(s)
	}

	@JvmSynthetic
	operator fun set(name: String, i: Int) {
		map[name] = IntTag(i)
	}

	@JvmSynthetic
	operator fun set(name: String, l: Long) {
		map[name] = LongTag(l)
	}

	@JvmSynthetic
	operator fun set(name: String, f: Float) {
		map[name] = FloatTag(f)
	}

	@JvmSynthetic
	operator fun set(name: String, d: Double) {
		map[name] = DoubleTag(d)
	}

	@JvmSynthetic
	operator fun set(name: String, s: String) {
		map[name] = StringTag(s)
	}

	@JvmSynthetic
	operator fun set(name: String, tag: Tag) {
		map[name] = tag
	}
}
