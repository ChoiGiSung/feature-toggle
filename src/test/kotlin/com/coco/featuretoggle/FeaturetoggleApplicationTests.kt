package com.coco.featuretoggle

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FeaturetoggleApplicationTests {

	@Autowired
	lateinit var service: SampleService


	@Test
	fun defaultFeaturetoggle() {
		val result = service.defaultFeatureMethod()
		assertThat(result).isEqualTo(Stub.DEFAULT_FEATURE)
	}

	@Test
	fun permissionFeaturetoggle() {
		val result = service.permissionFeatureMethod()
		assertThat(result).isEqualTo(Stub.PERMISSION_FEATURE)
	}

	@Test
	fun canaryFeaturetoggle() {
		val result = service.canaryFeatureMethod()
		assertThat(result).isEqualTo(Stub.CANARY_FEATURE)
	}
}
