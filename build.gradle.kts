import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import com.github.benmanes.gradle.versions.updates.gradle.GradleReleaseChannel.CURRENT
import org.gradle.api.tasks.wrapper.Wrapper.DistributionType.ALL

// Without these suppressions version catalog usage here and in other build
// files is marked red by IntelliJ:
// https://github.com/gradle/gradle/issues/22797.
@Suppress(
	"DSL_SCOPE_VIOLATION",
	"MISSING_DEPENDENCY_CLASS",
	"UNRESOLVED_REFERENCE_WRONG_RECEIVER",
	"FUNCTION_CALL_EXPECTED"
)
plugins {
	alias(libs.plugins.versions.gradle.plugin)
}

allprojects {
	group = "com.ianbrandt"
	version = "1.0-SNAPSHOT"
}

tasks {

	withType<DependencyUpdatesTask>().configureEach {
		rejectVersionIf {
			isNonStable(candidate.version)
		}
		gradleReleaseChannel = CURRENT.id
	}

	named<Wrapper>("wrapper").configure {
		gradleVersion = "7.6"
		distributionType = ALL
	}
}

fun isNonStable(version: String): Boolean {
	val stableKeyword = listOf("RELEASE", "FINAL", "GA").any {
		version.toUpperCase()
			.contains(it)
	}
	val unstableKeyword =
		listOf("""M\d+""").any { version.toUpperCase().contains(it.toRegex()) }
	val regex = "^[0-9,.v-]+(-r)?$".toRegex()
	val isStable = (stableKeyword && !unstableKeyword) || regex.matches(version)
	return isStable.not()
}