plugins {
	id("java-platform")
}

group = "com.ianbrandt.platforms"
version = "1.0-SNAPSHOT"

dependencies {
	constraints {
		api(libs.kotlin.gradle.plugin.dependency)
		api(libs.kotlin.spring.gradle.plugin.dependency)
		api(libs.spring.boot.gradle.plugin.dependency)
	}
}
