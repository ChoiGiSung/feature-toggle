package com.coco.featuretoggle

// 신규 로직에 적용할 Annotation
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class FeatureToggle(
    val key: String,
    val fallbackMethod: String = "",
)