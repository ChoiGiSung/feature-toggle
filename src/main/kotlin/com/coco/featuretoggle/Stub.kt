package com.coco.featuretoggle

object Stub {
    const val TRUE_FEATURE = "sample-feature-true"
    const val FALSE_FEATURE = "sample-feature-false"

    class ToggleRepository{
        fun findAll(): List<ToggleConfiguration>{
            return listOf(
                ToggleConfiguration(TRUE_FEATURE, true),
                ToggleConfiguration(FALSE_FEATURE, false)
            )
        }
    }

    class ToggleConfiguration(
        val key: String,
        val value: Boolean
    )

}