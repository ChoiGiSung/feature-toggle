package com.coco.featuretoggle

import com.coco.featuretoggle.Stub.UserHolder.userId

object Stub {
    const val DEFAULT_FEATURE = "DEFAULT_FEATURE"
    const val PERMISSION_FEATURE = "PERMISSION_FEATURE"
    const val CANARY_FEATURE = "CANARY_FEATURE"

    class ToggleRepository {
        fun findAll(): List<ToggleConfiguration> {
            return listOf(
                ToggleConfiguration(
                    key = DEFAULT_FEATURE,
                    enabled = false,
                    debug = true,
                    permission = ToggleConfiguration.PermissionToggle(
                        enabled = false,
                        debug = true,
                        userIds = setOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                    ),
                    canary = ToggleConfiguration.CanaryToggle(
                        enabled = false,
                        debug = true,
                        percentage = 50
                    )
                ),
                ToggleConfiguration(
                    key = PERMISSION_FEATURE,
                    enabled = false,
                    debug = true,
                    permission = ToggleConfiguration.PermissionToggle(
                        enabled = true,
                        debug = true,
                        userIds = setOf(1, 2, 3, 4, 5, 6, 7, 8, 9, userId)
                    ),
                    canary = ToggleConfiguration.CanaryToggle(
                        enabled = false,
                        debug = true,
                        percentage = 50
                    )
                ),
                ToggleConfiguration(
                    key = CANARY_FEATURE,
                    enabled = false,
                    debug = true,
                    permission = ToggleConfiguration.PermissionToggle(
                        enabled = false,
                        debug = true,
                        userIds = setOf(1, 2, 3, 4, 5, 6, 7, 8, 9, userId)
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
        var userId = 10L
    }

}