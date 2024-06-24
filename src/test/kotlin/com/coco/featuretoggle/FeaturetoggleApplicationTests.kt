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
	fun trueFeaturetoggle() {
		val result = service.trueMethod()
		assertThat(result).isEqualTo("new")
	}

	@Test
	fun falseFeaturetoggle() {
		val result = service.falseMethod()
		assertThat(result).isEqualTo("old")
	}
}
