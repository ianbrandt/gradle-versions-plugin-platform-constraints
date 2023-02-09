plugins {
	id("java-platform")
}

group = "com.ianbrandt.platforms"
version = "1.0-SNAPSHOT"

javaPlatform {
	allowDependencies()
}

dependencies {

	api(platform(libs.kotlinx.coroutines.bom))
	api(platform(libs.spring.boot.bom))

	constraints {
		api(libs.jetbrains.annotations)
		api(libs.bundles.kotlinx.datetime.jvm)
	}
}
