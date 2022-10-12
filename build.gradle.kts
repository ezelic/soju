/*
 * Champagne
 * Copyright (C) 2022 Shuuyu
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

import org.gradle.api.tasks.wrapper.Wrapper.DistributionType.ALL

plugins {
    kotlin("jvm") version "1.7.20" apply false
    id("org.jetbrains.dokka") version "1.7.20"
    kotlin("plugin.serialization") version "1.7.20" apply false
    id("org.jetbrains.kotlinx.binary-compatibility-validator") version "0.11.1"
    id("dev.architectury.loom") version "0.12.0-SNAPSHOT" apply false
    id("gg.essential.loom") version "0.10.0.+" apply false
    id("io.github.juuxel.loom-quiltflower") version "1.7.4" apply false
    signing
    `maven-publish`
}

dependencies {
    dokkaHtmlPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.7.20")
}

tasks {
    wrapper {
        version = "7.5.1"
        distributionType = BIN
    }

    dokkaHtml.configure {
        outputDirectory.set(buildDir.resolve("dokka"))
        moduleName.set("Nexus")
        moduleVersion.set("1.0.0")
        dokkaSourceSets {
            configureEach {
                jdkVersion.set(17)
            }
        }
    }
}

allprojects {
    version = "0.0.1-SNAPSHOT"
    group = "live.shuuyu.blossom"

    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
        maven("https://maven.fabricmc.net")
        maven("https://maven.architectury.dev/")
        maven("https://maven.minecraftforge.net/")
        maven("https://maven.quiltmc.org/repository/release")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
}