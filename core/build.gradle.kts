import kotlinx.atomicfu.plugin.gradle.configureJvmTransformation

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

plugins {
    `champagne-module`
    `champagne-publishing`
    groovy
    java
}

repositories {
    mavenCentral()
}

dependencies {
    val lwjglVersion = "3.3.1"
    val kotlinVersion = "1.7.10"
    val coroutinesVersion = "1.6.4"
    val serializationVersion = "1.4.0"
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core-jvm:$serializationVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:$serializationVersion")
    compileOnly("org.lwjgl:lwjgl-opengl:$lwjglVersion")
    implementation("org.lwjgl:lwjgl:$lwjglVersion:natives-windows")
    implementation("org.lwjgl:lwjgl:$lwjglVersion:natives-linux")
    implementation("org.lwjgl:lwjgl:$lwjglVersion:natives-macos")
    implementation("org.lwjgl:lwjgl:$lwjglVersion:natives-macos-arm64")
    api(kotlin("stdlib-jdk8"))
}
