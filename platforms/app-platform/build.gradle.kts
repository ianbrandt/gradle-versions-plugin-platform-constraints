plugins {
	id("java-platform")
}

group = "com.ianbrandt.platforms"
version = "1.0-SNAPSHOT"

javaPlatform {
	allowDependencies()
}

dependencies {

	components.all<SpringBomAlignmentRule>()

	api(platform(libs.spring.bom))
	api(platform(libs.spring.boot.bom))

	constraints {
		api(libs.jetbrains.annotations)
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
