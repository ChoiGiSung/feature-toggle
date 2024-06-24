package com.coco.featuretoggle

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component

@Aspect
@Component
class FeatureToggleAspect(
    private val featureToggleProvider: FeatureToggleProvider
) {
    private val fallbackExecutor = FeatureToggleFallbackExecutor()
    @Pointcut(value = "@within(featureToggle) || @annotation(featureToggle)", argNames = "featureToggle")
    fun matchAnnotatedClassOrMethod(featureToggle: FeatureToggle) {
    }
    @Around(value = "matchAnnotatedClassOrMethod(featureToggleAnnotation)", argNames = "proceedingJoinPoint, featureToggleAnnotation")
    fun featureToggleAroundAdvice(proceedingJoinPoint: ProceedingJoinPoint, featureToggleAnnotation: FeatureToggle): Any? {
        val key = featureToggleAnnotation.key
        val fallbackMethod = featureToggleAnnotation.fallbackMethod

        // Toggle Point
        if (featureToggleProvider.isEnabled(key)) {
            return proceedingJoinPoint.proceed()
        }

        return fallbackExecutor.execute(proceedingJoinPoint, key, fallbackMethod)
    }
}