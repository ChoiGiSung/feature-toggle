package com.coco.featuretoggle

import com.coco.featuretoggle.Stub.CANARY_FEATURE
import com.coco.featuretoggle.Stub.DEFAULT_FEATURE
import com.coco.featuretoggle.Stub.PERMISSION_FEATURE
import org.springframework.stereotype.Service

@Service
class SampleService {

    @FeatureToggle(key = DEFAULT_FEATURE, fallbackMethod = "oldGetSample")
    fun defaultFeatureMethod(): String {
        return DEFAULT_FEATURE
    }

    @FeatureToggle(key = PERMISSION_FEATURE, fallbackMethod = "oldGetSample")
    fun permissionFeatureMethod(): String {
        return PERMISSION_FEATURE
    }

    @FeatureToggle(key = CANARY_FEATURE, fallbackMethod = "oldGetSample")
    fun canaryFeatureMethod(): String {
        return CANARY_FEATURE
    }


    @FeatureToggleFallback
    fun oldGetSample(): String {
        return "old"
    }

}