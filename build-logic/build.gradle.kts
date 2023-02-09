plugins {
	`kotlin-dsl`
}

dependencies {

	implementation(platform("com.ianbrandt.platforms:plugins-platform"))

	implementation(libs.kotlin.gradle.plugin.dependency)
	implementation(libs.kotlin.spring.gradle.plugin.dependency)
	implementation(libs.spring.boot.gradle.plugin.dependency)
}
