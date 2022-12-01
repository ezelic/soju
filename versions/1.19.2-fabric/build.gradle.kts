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
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("dev.architectury.loom")
    id("io.github.juuxel.loom-quiltflower")
}

quiltflower {
    quiltflowerVersion.set("1.8.1")
}

dependencies {
    implementation(project(":soju-core"))
    minecraft("com.mojang:minecraft:1.19.1")
    mappings("net.fabricmc:yarn:1.19.1+build.1:v2")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.68.1+1.19.3")
    modImplementation(libs.bundles.fabric.bundle)
}