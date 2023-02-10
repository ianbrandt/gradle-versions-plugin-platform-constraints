plugins {
	id("com.ianbrandt.buildlogic.kotlin-project")
	id("com.ianbrandt.buildlogic.test.integration-test-suite")
	kotlin("plugin.spring")
}

dependencies {

	modules {
		module("org.springframework.boot:spring-boot-starter-logging") {
			replacedBy(
				"org.springframework.boot:spring-boot-starter-log4j2",
				"Use Log4j2 instead of Logback"
			)
		}
	}

	api(platform("com.ianbrandt.platforms:app-platform"))

	implementation("org.springframework.boot:spring-boot-starter-log4j2")

	runtimeOnly(kotlin("reflect"))

	"integrationTestImplementation"("org.springframework.boot:spring-boot-starter-test")
}
