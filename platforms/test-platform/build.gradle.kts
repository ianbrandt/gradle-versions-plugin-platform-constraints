plugins {
	id("java-platform")
}

group = "com.ianbrandt.platforms"
version = "1.0-SNAPSHOT"

javaPlatform {
	allowDependencies()
}

dependencies {

	api(platform(libs.junit.bom))
	api(platform(libs.kotlinx.coroutines.bom))

	constraints {
		api(libs.assertj)
		api(libs.bundles.mockk.jvm)
	}
}
