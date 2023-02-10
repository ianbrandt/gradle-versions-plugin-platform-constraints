plugins {
	id("java-platform")
}

group = "com.ianbrandt.platforms"
version = "1.0-SNAPSHOT"

dependencies {
	constraints {
		api(libs.spring.boot.gradle.plugin.dependency)
	}
}
