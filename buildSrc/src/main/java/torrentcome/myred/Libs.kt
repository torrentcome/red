
object Libs {
    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${ProjectProperties.Kotlin.version}"
    }

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.1.0"
        const val coreKtx = "androidx.core:core-ktx:1.2.0"
    }

    object Google {
        const val material = "com.google.android.material:material:1.1.0"
    }

    object Koin {
        const val koin_version = "2.1.5"

        const val core = "org.koin:koin-core:$koin_version"
        const val android = "org.koin:koin-android:$koin_version"
        const val viewmodel = "org.koin:koin-android-viewmodel:$koin_version"
    }

    object Test{
        const val junit = "junit:junit:4.12"
        const val testng = "org.testng:testng:6.9.6"
    }
}
