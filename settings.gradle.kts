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

@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://jitpack.io")
        maven("https://maven.fabricmc.net")
        maven("https://maven.quiltmc.org/repository/release")
        maven("https://maven.minecraftforge.net/")
        maven("https://maven.architectury.dev/")
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.jetbrains.dokka") {
                useModule("org.jetbrains.dokka:dokka-gradle-plugin:${requested.version}")
            }
        }
    }
}

rootProject.name = "champagne"

include(":core")


/**
 * Implements all Ktor implementation within a single implementation.
 *
 * @author yujin
 */
// Apparently bom doesn't exist on ktor anymore?
fun VersionCatalogBuilder.ktor() {
    val ktorVersion = version("ktor", "2.1.0")

    // library("ktor-bom", "io.ktor", "ktor-bom").versionRef(ktorVersion)
    library("ktor-client-json", "io.ktor", "ktor-client-json").versionRef(ktorVersion)
    library("ktor-client-websockets", "io.ktor", "ktor-client-websockets").versionRef(ktorVersion)
    library("ktor-server-core-jvm", "io.ktor", "ktor-server-core-jvm").versionRef(ktorVersion)
    library("ktor-client-core-jvm", "io.ktor", "ktor-client-core-jvm").versionRef(ktorVersion)
    library("ktor-client-cio-jvm", "io.ktor", "ktor-client-cio-jvm").versionRef(ktorVersion)
    library("ktor-client-content-negotiation-jvm", "io.ktor", "ktor-client-content-negotiation-jvm").versionRef(ktorVersion)

    bundle("ktor-bundle", listOf(
        // "ktor-bom",
        "ktor-client-json",
        "ktor-client-websockets",
        "ktor-server-core-jvm",
        "ktor-client-core-jvm",
        "ktor-client-cio-jvm",
        "ktor-client-content-negotiation-jvm",
    ))
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            ktor()
            lwjgl3()
            kotlinLibs()
            commonmark()
            fabriccommons()
        }
    }
}

/**
 * Implements all LWJGL 3 packages within a single implementation.
 *
 * @author yujin
 */
fun VersionCatalogBuilder.lwjgl3() {
    val lwjglVersion = version("lwjgl", "3.3.1")

    library("lwjgl", "org.lwjgl", "lwjgl").versionRef(lwjglVersion)
    library("lwjgl-opengl", "org.lwjgl", "lwjgl-opengl").versionRef(lwjglVersion)

    bundle("lwjgl-bundle", listOf(
        "lwjgl",
        "lwjgl-opengl",
    ))
}

/**
 * Implements all Kotlin specific libs in one implementation.
 *
 * @author yujin
 */
fun VersionCatalogBuilder.kotlinLibs() {
    val kotlinVersion = version("kotlin", "1.7.10")
    val coroutineVersion = version("coroutuine", "1.6.4")
    val serializationVersion = version("serialization", "1.4.0")
    val atomicfuVersion = version("atomicfu", "0.18.3")

    library("kotlin-stdlib", "org.jetbrains.kotlin", "kotlin-stdlib").versionRef(kotlinVersion)
    library("kotlin-stdlib-jdk7", "org.jetbrains.kotlin", "kotlin-stdlib-jdk7").versionRef(kotlinVersion)
    library("kotlin-stdlib-jdk8", "org.jetbrains.kotlin", "kotlin-stdlib-jdk8").versionRef(kotlinVersion)
    library("kotlin-reflect", "org.jetbrains.kotlin", "kotlin-reflect").versionRef(kotlinVersion)
    library("kotlinx-coroutines-core", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").versionRef(coroutineVersion)
    library("kotlinx-coroutines-core-jvm", "org.jetbrains.kotlinx", "kotlinx-coroutines-core-jvm").versionRef(coroutineVersion)
    library("kotlinx-coroutines-jdk8", "org.jetbrains.kotlinx", "kotlinx-coroutines-jdk8").versionRef(coroutineVersion)
    library("kotlinx-serialization", "org.jetbrains.kotlinx", "kotlinx-serialization-json").versionRef(serializationVersion)
    library("kotlinx-serialization-core-jvm", "org.jetbrains.kotlinx", "kotlinx-serialization-core-jvm").versionRef(serializationVersion)
    library("kotlinx-serialization-json-jvm", "org.jetbrains.kotlinx", "kotlinx-serialization-json-jvm").versionRef(serializationVersion)
    library("atomicfu", "org.jetbrains.kotlinx", "atomicfu").versionRef(atomicfuVersion)

    bundle("kotlinLibs-bundle", listOf(
        "kotlin-stdlib",
        "kotlin-stdlib-jdk7",
        "kotlin-stdlib-jdk8",
        "kotlin-reflect",
        "kotlinx-coroutines-core",
        "kotlinx-coroutines-core-jvm",
        "kotlinx-coroutines-jdk8",
        "atomicfu",
    ))
}

/**
 * Implements all CommonMark specific libs in one implementation
 *
 * @author yujin
 */
fun VersionCatalogBuilder.commonmark() {
    val commonmarkVersion = version("commonmark", "0.19.0")

    library("commonmark", "org.commonmark", "commonmark").versionRef(commonmarkVersion)
    library("commonmark-ext-gfm-strikethrough", "org.commonmark", "commonmark-ext-gfm-strikethrough").versionRef(commonmarkVersion)
    library("commonmark-ext-ins", "org.commonmark", "commonmark-ext-ins").versionRef(commonmarkVersion)

    bundle("commonmark-bundle", listOf(
        "commonmark",
        "commonmark-ext-gfm-strikethrough",
        "commonmark-ext-ins",
    ))
}

/**
 * Implements all Fabric related dependencies. However, each
 * Fabric version will require their own FAPI version, which
 * you will have to update seperately for convenience’s sake. Anything
 * that shares the same dependency will be placed here.
 *
 * @author yujin
 * @since 0.1-SNAPSHOT
 */
fun VersionCatalogBuilder.fabriccommons() {
    val fabricKotlinVersion = version("fabric-language-kotlin", "1.8.2+kotlin.1.7.10")
    val fabricLoaderVersion = version("fabric-loader", "0.14.9")

    library("fabric-language-kotlin", "net.fabricmc", "fabric-language-kotlin").versionRef(fabricKotlinVersion)
    library("fabric-loader", "net.fabricmc", "fabric-loader").versionRef(fabricLoaderVersion)

    bundle("fabric-bundle", listOf(
        "fabric-language-kotlin",
        "fabric-loader",
    ))
}