import org.gradle.api.tasks.wrapper.Wrapper.DistributionType.ALL

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("org.jetbrains.kotlinx.binary-compatibility-validator") version "0.10.1"
    id("org.jetbrains.dokka")
    signing
    `maven-publish`
}

repositories {
    mavenCentral()
}

group = Constants.group
version = Constants.version

tasks {
    wrapper {
        gradleVersion = "7.5"
        distributionType = ALL
    }
}