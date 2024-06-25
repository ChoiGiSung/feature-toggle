package com.coco.featuretoggle

import com.coco.featuretoggle.Stub.UserHolder.userId

object Stub {
    const val TRUE_FEATURE = "sample-feature-true"
    const val FALSE_FEATURE = "sample-feature-false"

    class ToggleRepository {
        fun findAll(): List<ToggleConfiguration> {
            return listOf(
                ToggleConfiguration(
                    key = TRUE_FEATURE,
                    enabled = true,
                    debug = true,
                    permission = ToggleConfiguration.PermissionToggle(
                        enabled = true,
                        debug = true,
                        userIds = setOf(userId, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                    ),
                    canary = ToggleConfiguration.CanaryToggle(
                        enabled = true,
                        debug = true,
                        percentage = 50
                    )
                )
            )
        }
    }

    object UserHolder {
        var userId = 1L
    }

}