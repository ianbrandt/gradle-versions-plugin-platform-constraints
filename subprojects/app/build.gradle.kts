// https://github.com/gradle/gradle/issues/22797
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
	alias(libs.plugins.spring.boot.plugin)
	id("com.ianbrandt.buildlogic.spring-project")
	id("com.ianbrandt.buildlogic.test.integration-test-suite")
}

dependencies {

	api(platform("com.ianbrandt.platforms:app-platform"))

	api(libs.spring.boot.starter)
	api(libs.spring.boot.starter.webflux)

	implementation(libs.spring.boot)
	implementation(libs.spring.boot.autoconfigure)
	implementation(libs.spring.context)

	integrationTestImplementation(libs.spring.boot.starter.test)
}
