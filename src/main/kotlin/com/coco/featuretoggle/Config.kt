package com.coco.featuretoggle

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config {

    @Bean
    fun featureToggleProvider(): FeatureToggleProvider {
        return FeatureToggleProvider(Stub.ToggleRepository())
    }
}