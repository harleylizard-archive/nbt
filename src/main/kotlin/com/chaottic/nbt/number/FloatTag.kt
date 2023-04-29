package com.chaottic.nbt.number

import com.chaottic.nbt.TagType
import java.io.DataInput

data class FloatTag(private val f: Float) : NumberTag {

	override fun asByte() = f.toInt().toByte()
	override fun asShort() = f.toInt().toShort()
	override fun asInt() = f.toInt()
	override fun asLong() = f.toLong()
	override fun asFloat() = f
	override fun asDouble() = f.toDouble()

	companion object : TagType<FloatTag> {

		override fun createTag(dataInput: DataInput) = FloatTag(dataInput.readFloat())
	}
}
