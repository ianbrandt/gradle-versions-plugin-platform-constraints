import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm")
	id("com.ianbrandt.buildlogic.test.unit-test-suite")
}

val javaTargetVersion = JavaVersion.VERSION_11.toString()
val kotlinTargetVersion = "1.8"

kotlin {
	jvmToolchain {
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

	withType<KotlinCompile>().configureEach {
		kotlinOptions {
			languageVersion = kotlinTargetVersion
			apiVersion = kotlinTargetVersion
			jvmTarget = javaTargetVersion
			freeCompilerArgs = listOf(
				"-Xjsr305=strict",
				"-opt-in=kotlin.ExperimentalStdlibApi",
				"-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
			)
		}
	}
}
