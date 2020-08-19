// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    repositories {
        google()
        jcenter()
        mavenCentral()
        maven(url ="https://jitpack.io")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.2.0-alpha01")
        classpath(kotlin("gradle-plugin", version = ProjectProperties.Kotlin.version))

    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven(url ="https://jitpack.io")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
