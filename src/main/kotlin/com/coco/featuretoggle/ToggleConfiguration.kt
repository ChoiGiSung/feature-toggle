package com.coco.featuretoggle

class ToggleConfiguration(
    val key: String,
    val enabled: Boolean,
    val debug: Boolean,
    val permission: PermissionToggle,
    val canary: CanaryToggle
) {
    fun isPermittedUser(userId: Long?): Boolean {
        return this.permission.enabled && this.permission.userIds.contains(userId)
    }

    fun isCanaryGroupedUser(userId: Long?): Boolean {
        if (userId == null) return false
        val userHash = userId % 100
        return this.canary.enabled && userHash < canary.percentage
    }

    class PermissionToggle(
        val enabled: Boolean,
        val debug: Boolean,
        val userIds: Set<Long>
    )

    class CanaryToggle(
        val enabled: Boolean,
        val debug: Boolean,
        val percentage: Int
    )
}