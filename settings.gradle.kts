

/*
 * This file is part of Blossom, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2022 Myosyn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
        maven("https://maven.fabricmc.net")
        maven("https://maven.architectury.dev/")
        maven("https://maven.minecraftforge.net/")
        maven("https://maven.quiltmc.org/repository/release")
        maven("https://repo.essential.gg/repository/maven-public")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.jetbrains.dokka") {
                useModule("org.jetbrains.dokka:dokka-gradle-plugin:${requested.version}")
            }

            if (requested.id.id == "kotlinx-atomicfu") {
                useModule("org.jetbrains.kotlinx:atomicfu-gradle-plugin:${requested.version}")
            }
        }
    }
}

rootProject.name = "Blossom"

include(":soju-core")
include(":soju-common")
include(":versions:1.19.2-fabric")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            ktor()
            lwjgl3()
            kotlinLibs()
            commonmark()
            fabriccommons()
            nightconfig()
        }
    }
}

/**
 * Implements all Ktor implementation within a single implementation.
 *
 * @author yujin
 */
// Apparently bom doesn't exist on ktor anymore?
fun VersionCatalogBuilder.ktor() {
    val ktorVersion = "2.1.2"

    library("ktor-client-json", "io.ktor", "ktor-client-json").version(ktorVersion)
    library("ktor-client-websockets", "io.ktor", "ktor-client-websockets").version(ktorVersion)
    library("ktor-client-core-jvm", "io.ktor", "ktor-client-core-jvm").version(ktorVersion)
    library("ktor-client-cio-jvm", "io.ktor", "ktor-client-cio-jvm").version(ktorVersion)
    library("ktor-client-content-negotiation-jvm", "io.ktor", "ktor-client-content-negotiation-jvm").version(ktorVersion)

    bundle(
        "ktor-bundle", listOf(
            "ktor-client-json",
            "ktor-client-websockets",
            "ktor-client-core-jvm",
            "ktor-client-cio-jvm",
            "ktor-client-content-negotiation-jvm",
        )
    )
}

/**
 * Implements all LWJGL 3 packages within a single implementation.
 *
 * @author yujin
 */
fun VersionCatalogBuilder.lwjgl3() {
    val lwjglVersion = "3.3.1"

    library("lwjgl", "org.lwjgl", "lwjgl").version(lwjglVersion)
    library("lwjgl-opengl", "org.lwjgl", "lwjgl-opengl").version(lwjglVersion)

    bundle(
        "lwjgl-bundle", listOf(
            "lwjgl",
            "lwjgl-opengl",
        )
    )
}

/**
 * Implements all Kotlin specific libs in one implementation.
 *
 * @author yujin
 */
fun VersionCatalogBuilder.kotlinLibs() {
    val kotlinVersion = "1.7.20"
    val coroutineVersion = "1.6.4"
    val serializationVersion = "1.4.0"
    val atomicfuVersion = "0.18.3"

    library("kotlin-stdlib", "org.jetbrains.kotlin", "kotlin-stdlib").version(kotlinVersion)
    library("kotlin-stdlib-jdk7", "org.jetbrains.kotlin", "kotlin-stdlib-jdk7").version(kotlinVersion)
    library("kotlin-stdlib-jdk8", "org.jetbrains.kotlin", "kotlin-stdlib-jdk8").version(kotlinVersion)
    library("kotlin-reflect", "org.jetbrains.kotlin", "kotlin-reflect").version(kotlinVersion)
    library("kotlinx-coroutines-core", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").version(coroutineVersion)
    library("kotlinx-coroutines-core-jvm", "org.jetbrains.kotlinx", "kotlinx-coroutines-core-jvm").version(coroutineVersion)
    library("kotlinx-coroutines-jdk8", "org.jetbrains.kotlinx", "kotlinx-coroutines-jdk8").version(coroutineVersion)
    library("kotlinx-serialization", "org.jetbrains.kotlinx", "kotlinx-serialization-json").version(serializationVersion)
    library("atomicfu", "org.jetbrains.kotlinx", "atomicfu").version(atomicfuVersion)

    bundle(
        "kotlinLibs-bundle", listOf(
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
    val commonmarkVersion = "0.19.0"

    library("commonmark", "org.commonmark", "commonmark").version(commonmarkVersion)
    library("commonmark-ext-gfm-strikethrough", "org.commonmark", "commonmark-ext-gfm-strikethrough").version(commonmarkVersion)
    library("commonmark-ext-ins", "org.commonmark", "commonmark-ext-ins").version(commonmarkVersion)

    bundle(
        "commonmark-bundle", listOf(
            "commonmark",
            "commonmark-ext-gfm-strikethrough",
            "commonmark-ext-ins",
        )
    )
}

fun VersionCatalogBuilder.nightconfig() {
    val nightconfigVersion = "3.6.6"

    library("core", "com.electronwill.night-config", "core").version(nightconfigVersion)
    library("toml", "com.electronwill.night-config", "toml").version(nightconfigVersion)

    bundle("nightconfig-bundle", listOf(
            "core",
            "toml",
        )
    )
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
    val fabricKotlinVersion = "1.8.4+kotlin.1.7.20"
    val fabricLoaderVersion = "0.14.9"

    library("fabric-language-kotlin", "net.fabricmc", "fabric-language-kotlin").version(fabricKotlinVersion)
    library("fabric-loader", "net.fabricmc", "fabric-loader").version(fabricLoaderVersion)

    bundle("fabric-bundle", listOf(
            "fabric-language-kotlin", "fabric-loader",
        )
    )
}