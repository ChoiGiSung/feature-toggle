package com.coco.featuretoggle

object Stub {

    class ToggleRepository{
        fun findAll(): List<ToggleConfiguration>{
            return emptyList()
        }
    }

    class ToggleConfiguration(
        val key: String,
        val value: Boolean
    )
}