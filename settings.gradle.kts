pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.jetbrains.dokka") {
                useModule("org.jetbrains.dokka:dokka-gradle-plugin:${requested.version}")
            }
        }
    }
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

rootProject.name = "champagne"

include(":core")