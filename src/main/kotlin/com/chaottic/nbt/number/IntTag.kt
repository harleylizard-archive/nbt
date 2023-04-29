package com.chaottic.nbt.number

import com.chaottic.nbt.TagType
import java.io.DataInput

@JvmInline
value class IntTag(private val i: Int) : NumberTag {

	override fun asByte() = i.toByte()
	override fun asShort() = i.toShort()
	override fun asInt() = i
	override fun asLong() = i.toLong()
	override fun asFloat() = i.toFloat()
	override fun asDouble() = i.toDouble()

	companion object : TagType<IntTag> {

		override fun createTag(dataInput: DataInput) = IntTag(dataInput.readInt())
	}
}
