plugins {
	idea
	`jvm-test-suite`
	id("com.ianbrandt.buildlogic.test.unit-test-suite")
}

val integrationTestSuiteName = "integrationTest"

@Suppress("UnstableApiUsage")
testing {
	suites {

		val test by getting(JvmTestSuite::class)

		register<JvmTestSuite>(integrationTestSuiteName) {

			dependencies {
				implementation(project())
			}

			sources {
				java {
					setSrcDirs(listOf("src/it/java"))
				}
			}

			targets {
				all {
					testTask.configure {
						filter {
							includeTestsMatching("*IT")
						}
						shouldRunAfter(test)
					}
				}
			}
		}
	}
}

dependencies {

	// Version catalog not available in precompiled script plugins:
	// https://github.com/gradle/gradle/issues/15383

	"integrationTestImplementation"(
		platform("com.ianbrandt.platforms:test-platform")
	)

	//"integrationTestImplementation"(libs.assertj.core)
	"integrationTestImplementation"("org.assertj:assertj-core")
}

tasks {

	named<Task>("check").configure {
		val integrationTest by existing
		dependsOn(integrationTest)
	}
}

idea {
	module {
		testSources.from(
			java.sourceSets[integrationTestSuiteName].java.srcDirs
		)
		testResources.from(
			java.sourceSets[integrationTestSuiteName].resources.srcDirs
		)
	}
}
