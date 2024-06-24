package com.coco.featuretoggle

import com.coco.featuretoggle.Stub.FALSE_FEATURE
import com.coco.featuretoggle.Stub.TRUE_FEATURE
import org.springframework.stereotype.Service

@Service
class SampleService {

    @FeatureToggle(key = TRUE_FEATURE, fallbackMethod = "oldGetSample")
    fun trueMethod(): String {
        return "new"
    }

    @FeatureToggle(key = FALSE_FEATURE, fallbackMethod = "oldGetSample")
    fun falseMethod(): String {
        return "new"
    }

    @FeatureToggleFallback
    fun oldGetSample(): String {
        return "old"
    }

}