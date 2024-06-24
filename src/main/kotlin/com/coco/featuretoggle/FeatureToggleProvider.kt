package com.coco.featuretoggle

import com.coco.featuretoggle.Stub.ToggleConfiguration
import com.coco.featuretoggle.Stub.ToggleRepository
import org.springframework.scheduling.annotation.Scheduled
import java.util.concurrent.atomic.AtomicReference

class FeatureToggleProvider(
    private val repository: ToggleRepository
) {
    // <ToggleKey, ToggleConfiguration>
    private val toggleConfigMap: AtomicReference<Map<String, ToggleConfiguration>> = AtomicReference(emptyMap())

    @Scheduled(fixedDelay = 5000)
    fun syncToggleConfiguration() {
        // Sync toggle configuration to toggleConfigMap
        val newToggleConfigMap = repository.findAll()
            .associateBy({ it.key }, { this.parseConfig(it) })
        toggleConfigMap.set(newToggleConfigMap)
    }

    private fun parseConfig(config: ToggleConfiguration): ToggleConfiguration {
        //custom parse something
        return ToggleConfiguration(config.key, config.value)
    }

    fun isEnabled(key: String): Boolean {
        val toggleConfig = toggleConfigMap.get()[key] ?: return false
        return toggleConfig.value
    }
}