plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(29)

    defaultConfig {
        applicationId = "torrentcome.myred"
        minSdkVersion(22)
        targetSdkVersion(29)
        versionCode = 1
        versionName =  "1.0"
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // kotlin
    implementation(Libs.Kotlin.stdlib)

    // androidx
    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.appCompat)

    // google
    implementation(Libs.Google.material)

    // koin
    implementation(Libs.Koin.core)
    implementation(Libs.Koin.android)
    implementation(Libs.Koin.viewmodel)

    // test
    implementation(Libs.Test.junit)
    implementation(Libs.Test.testng)
}
