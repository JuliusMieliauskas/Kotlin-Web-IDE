pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "Kotlin_rpc"
include("src:wasmJsMain")
findProject(":src:wasmJsMain")?.name = "wasmJsMain"
