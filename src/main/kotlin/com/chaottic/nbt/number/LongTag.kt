package com.chaottic.nbt.number

import com.chaottic.nbt.TagType
import java.io.DataInput

data class LongTag(private val l: Long) : NumberTag {

	override fun asByte() = l.toByte()
	override fun asShort() = l.toShort()
	override fun asInt() = l.toInt()
	override fun asLong() = l
	override fun asFloat() = l.toFloat()
	override fun asDouble() = l.toDouble()

	companion object : TagType<LongTag> {

		override fun createTag(dataInput: DataInput) = LongTag(dataInput.readLong())
	}
}
