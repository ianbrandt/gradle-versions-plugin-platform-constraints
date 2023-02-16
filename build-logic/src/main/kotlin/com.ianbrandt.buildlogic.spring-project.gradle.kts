plugins {
	id("com.ianbrandt.buildlogic.kotlin-project")
	id("com.ianbrandt.buildlogic.test.integration-test-suite")
	kotlin("plugin.spring")
}

dependencies {

	components.all<SpringBomAlignmentRule>()

	modules {
		module("org.springframework.boot:spring-boot-starter-logging") {
			replacedBy(
				"org.springframework.boot:spring-boot-starter-log4j2",
				"Use Log4j2 instead of Logback"
			)
		}
	}

	api(platform("com.ianbrandt.platforms:app-platform"))

	implementation("org.springframework.boot:spring-boot-starter-log4j2")

	runtimeOnly(kotlin("reflect"))

	"integrationTestImplementation"("org.springframework.boot:spring-boot-starter-test")
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
