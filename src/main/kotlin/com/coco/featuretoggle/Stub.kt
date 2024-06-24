package com.coco.featuretoggle

object Stub {
    const val TRUE_FEATURE = "sample-feature-true"
    const val FALSE_FEATURE = "sample-feature-false"

    class ToggleRepository {
        fun findAll(): List<ToggleConfiguration> {
            return listOf(
                ToggleConfiguration(TRUE_FEATURE, true),
                ToggleConfiguration(FALSE_FEATURE, false)
            )
        }
    }

    open class ToggleConfiguration(
        open val key: String,
        open val value: Boolean
    )

    class CanaryToggleConfiguration(
        override val key: String,
        override val value: Boolean,
        val debug: Boolean,
        val permittedUserIds: Set<Long> = emptySet(),
        val canaryUserPercentage: Int// 0 to 100
    ) : ToggleConfiguration(key, value)

}