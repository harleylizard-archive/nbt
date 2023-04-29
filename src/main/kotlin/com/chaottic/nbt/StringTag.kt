package com.chaottic.nbt

import java.io.DataInput

data class StringTag(val s: String) : Tag {

	companion object : TagType<StringTag> {

		override fun createTag(dataInput: DataInput) = StringTag(dataInput.readUTF())
	}
}
