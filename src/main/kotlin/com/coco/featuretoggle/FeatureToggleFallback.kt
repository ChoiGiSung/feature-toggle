package com.coco.featuretoggle

// 기존 로직에 적용할 Annotation
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class FeatureToggleFallback