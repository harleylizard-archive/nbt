package com.chaottic.nbt.number

import com.chaottic.nbt.TagType
import java.io.DataInput

data class ShortTag(private val s: Short) : NumberTag {

	override fun asByte() = s.toByte()
	override fun asShort() = s
	override fun asInt() = s.toInt()
	override fun asLong() = s.toLong()
	override fun asFloat() = s.toFloat()
	override fun asDouble() = s.toDouble()

	companion object : TagType<ShortTag> {

		override fun createTag(dataInput: DataInput) = ShortTag(dataInput.readShort())
	}
}
