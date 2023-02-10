plugins {
	`kotlin-dsl`
}

dependencies {

	implementation(platform("com.ianbrandt.platforms:plugins-platform"))

	implementation(libs.spring.boot.gradle.plugin.dependency)
}
