package com.chaottic.nbt.number

import com.chaottic.nbt.TagType
import java.io.DataInput

@JvmInline
value class DoubleTag(private val d: Double) : NumberTag {

	override fun asByte() = d.toLong().toByte()
	override fun asShort() = d.toLong().toShort()
	override fun asInt() = d.toInt()
	override fun asLong() = d.toLong()
	override fun asFloat() = d.toFloat()
	override fun asDouble() = d

	companion object : TagType<DoubleTag> {

		override fun createTag(dataInput: DataInput) = DoubleTag(dataInput.readDouble())
	}
}
