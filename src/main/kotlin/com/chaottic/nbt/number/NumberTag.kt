package com.chaottic.nbt.number

import com.chaottic.nbt.Tag

sealed interface NumberTag : Tag {
	fun asByte(): Byte
	fun asShort(): Short
	fun asInt(): Int
	fun asLong(): Long
	fun asFloat(): Float
	fun asDouble(): Double
}