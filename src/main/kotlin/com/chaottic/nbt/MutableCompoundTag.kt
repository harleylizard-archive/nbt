package com.chaottic.nbt

class MutableCompoundTag(override val map: MutableMap<String, Tag>) : CompoundTag(map) {

	constructor() : this(hashMapOf())
}
