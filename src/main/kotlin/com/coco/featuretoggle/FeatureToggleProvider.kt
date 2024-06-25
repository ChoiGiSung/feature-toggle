package com.coco.featuretoggle

import com.coco.featuretoggle.Stub.ToggleRepository
import org.springframework.scheduling.annotation.Scheduled
import java.util.concurrent.atomic.AtomicReference

class FeatureToggleProvider(
    private val repository: ToggleRepository
) {
    // <ToggleKey, ToggleConfiguration>
    private val toggleConfigMap: AtomicReference<Map<String, ToggleConfiguration>> = AtomicReference(emptyMap())

    //for test
    init {
        this.syncToggleConfiguration()
    }

    @Scheduled(fixedDelay = 5000)
    fun syncToggleConfiguration() {
        // Sync toggle configuration to toggleConfigMap
        val newToggleConfigMap = repository.findAll()
            .associateBy { it.key }
        toggleConfigMap.set(newToggleConfigMap)
    }

    fun isEnabled(key: String, userId: Long?): Boolean {
        val toggleConfig = this.toggleConfigMap.get()[key] ?: return false

        // Permissioning Toggle; 권한이 있는 사용자에게 Feature 적용
        if (toggleConfig.isPermittedUser(userId)) {
            if (toggleConfig.permission.debug) {
                println("[FeatureToggleProvider] Permission Toggle - key($key), userId($userId), enabled(true)")
            }
            return true
        }

        // Canary Toggle; Canary 그룹에 포함된 사용자에게 Feature 적용
        if (toggleConfig.isCanaryGroupedUser(userId)) {
            if (toggleConfig.canary.debug) {
                println("[FeatureToggleProvider] Canary Toggle - key($key), userId($userId), enabled(true)")
            }
            return true
        }

        if (toggleConfig.debug) {
            println("[FeatureToggleProvider] Feature Toggle - key($key), userId($userId), enabled(${toggleConfig.enabled})")
        }

        // 전체 사용자에게 Feature 적용
        return toggleConfig.enabled
    }
}