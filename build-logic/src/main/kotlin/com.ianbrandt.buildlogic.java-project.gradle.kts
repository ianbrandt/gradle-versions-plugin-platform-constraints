plugins {
	java
	id("com.ianbrandt.buildlogic.test.unit-test-suite")
}

val javaTargetVersion = JavaVersion.VERSION_11.toString()

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(javaTargetVersion))
	}
}

dependencies {

	api(platform("com.ianbrandt.platforms:app-platform"))
}

tasks {
	withType<JavaCompile>().configureEach {
		sourceCompatibility = javaTargetVersion
		targetCompatibility = javaTargetVersion
	}
}
