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

	components.all<SpringBomAlignmentRule>()

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

abstract class SpringBomAlignmentRule : ComponentMetadataRule {
	override fun execute(ctx: ComponentMetadataContext) {
		ctx.details.run {
			when (id.group) {
				"org.springframework" ->
					belongsTo(
						"org.springframework:spring-framework-bom:${id.version}",
						false
					)
				"org.springframework.boot" ->
					belongsTo(
						"org.springframework.boot:spring-boot-dependencies:${id.version}",
						false
					)
			}
		}
	}
}
