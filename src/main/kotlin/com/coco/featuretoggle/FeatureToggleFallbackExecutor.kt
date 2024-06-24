package com.coco.featuretoggle

import org.aspectj.lang.ProceedingJoinPoint
import java.lang.reflect.Method


class FeatureToggleFallbackExecutor(
) {

    fun execute(
        joinPoint: ProceedingJoinPoint,
        key: String,
        fallbackMethodName: String,
    ): Any? {
        val targetClass = joinPoint.target.javaClass
        val args = joinPoint.args
        val fallbackMethod = findFallbackMethod(targetClass, fallbackMethodName)
        //key something

        return fallbackMethod.invoke(joinPoint.target, *args)
    }

    private fun findFallbackMethod(targetClass: Class<Any>, methodName: String): Method {

        val methods = targetClass.methods
        for (method in methods) {
            if (method.isAnnotationPresent(FeatureToggleFallback::class.java)
                && method.name == methodName
            ) {
                // Check arguments if necessary
                return method
            }
        }
        throw RuntimeException("No fallback method found")
    }
}