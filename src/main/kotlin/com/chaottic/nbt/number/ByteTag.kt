package com.chaottic.nbt.number

import com.chaottic.nbt.TagType
import java.io.DataInput

@JvmInline
value class ByteTag(private val b: Byte) : NumberTag {

	override fun asByte() = b
	override fun asShort() = b.toShort()
	override fun asInt() = b.toInt()
	override fun asLong() = b.toLong()
	override fun asFloat() = b.toFloat()
	override fun asDouble() = b.toDouble()

	companion object : TagType<ByteTag> {

		override fun createTag(dataInput: DataInput) = ByteTag(dataInput.readByte())
	}
}
