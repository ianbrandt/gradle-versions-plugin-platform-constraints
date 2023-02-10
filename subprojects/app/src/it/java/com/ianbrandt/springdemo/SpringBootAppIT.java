package com.ianbrandt.springdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringBootAppIT {

	@Test
	void testContextLoads() {
		// Will fail if Spring application context loading throws an exception.
		assertThat(true).isTrue();
	}
}
