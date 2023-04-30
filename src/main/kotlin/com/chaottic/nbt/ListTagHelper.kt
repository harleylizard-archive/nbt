package com.chaottic.nbt

import com.chaottic.nbt.number.IntTag
import com.chaottic.nbt.number.NumberTag
import it.unimi.dsi.fastutil.bytes.*
import it.unimi.dsi.fastutil.doubles.*
import it.unimi.dsi.fastutil.floats.*
import it.unimi.dsi.fastutil.ints.IntArrayList
import it.unimi.dsi.fastutil.ints.IntList
import it.unimi.dsi.fastutil.ints.IntLists
import it.unimi.dsi.fastutil.longs.LongArrayList
import it.unimi.dsi.fastutil.longs.LongList
import it.unimi.dsi.fastutil.longs.LongLists
import it.unimi.dsi.fastutil.shorts.ShortArrayList
import it.unimi.dsi.fastutil.shorts.ShortList
import it.unimi.dsi.fastutil.shorts.ShortLists

object ListTagHelper {

	@JvmStatic
	fun ListTag.toByteList(): ByteList {
		val byteList = ByteArrayList(size)

		forEach { tag -> byteList.add((tag as NumberTag).asByte()) }

		return ByteLists.unmodifiable(byteList)
	}

	@JvmStatic
	fun ListTag.toShortList(): ShortList {
		val shortList = ShortArrayList(size)

		forEach { tag -> shortList.add((tag as NumberTag).asShort()) }

		return ShortLists.unmodifiable(shortList)
	}

	@JvmStatic
	fun ListTag.toIntList(): IntList {
		val intList = IntArrayList(size)

		forEach { tag -> intList.add((tag as NumberTag).asInt()) }

		return IntLists.unmodifiable(intList)
	}

	@JvmStatic
	fun ListTag.toLongList(): LongList {
		val longList = LongArrayList(size)

		forEach { tag -> longList.add((tag as NumberTag).asLong()) }

		return LongLists.unmodifiable(longList)
	}

	@JvmStatic
	fun ListTag.toFloatList(): FloatList {
		val floatList = FloatArrayList(size)

		forEach { tag -> floatList.add((tag as NumberTag).asFloat()) }

		return FloatLists.unmodifiable(floatList)
	}

	@JvmStatic
	fun ListTag.toDoubleList(): DoubleList {
		val doubleList = DoubleArrayList(size)

		forEach { tag -> doubleList.add((tag as NumberTag).asDouble()) }

		return DoubleLists.unmodifiable(doubleList)
	}
}