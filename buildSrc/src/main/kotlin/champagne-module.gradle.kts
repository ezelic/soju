import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("org.jetbrains.dokka")
    id("kotlinx-atomicfu")
}

dependencies {
    testImplementation(kotlin("test"))
    testRuntimeOnly(kotlin("test-junit5"))
}

tasks {
    val compileTestKotlin: KotlinCompile by tasks

    "compileJava"(JavaCompile::class) {
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = JavaVersion.VERSION_17.toString()
    }
    "compileKotlin"(KotlinCompile::class) {
        kotlinOptions {
            jvmTarget = "17"
            allWarningsAsErrors = true
            freeCompilerArgs = listOf(

            )
        }
    }

    "test"(Test::class) {
        useJUnitPlatform()
    }
    dokkaHtml.configure {
        this.outputDirectory.set(project.projectDir.resolve("dokka").resolve("champagne"))
    }
}