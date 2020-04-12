plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(29)

    defaultConfig {
        applicationId = "torrentcome.myred"
        minSdkVersion(22)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            postprocessing {
                isObfuscate = true
                isOptimizeCode = true
                isRemoveUnusedCode = true
                proguardFiles("proguard-rules.pro")
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    // kotlin
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Kotlinx.couroutineCore)
    implementation(Libs.Kotlinx.couroutineAndroid)
    // androidx
    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.constraintLayout)
    // google
    implementation(Libs.Google.material)
    // exoplayer
    implementation(Libs.Google.exoplayerCore)
    // koin
    implementation(Libs.Koin.core)
    implementation(Libs.Koin.android)
    implementation(Libs.Koin.viewmodel)
    implementation(Libs.Koin.architecture)
    // room
    implementation(Libs.Room.ktx)
    implementation(Libs.Room.runtime)
    kapt(Libs.Room.compiler)
    // test
    implementation(Libs.Test.junit)
    implementation(Libs.Test.testng)
}
