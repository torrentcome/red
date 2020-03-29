
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

        private const val exoplayer_version = "2.11.3"
        const val exoplayerCore = "com.google.android.exoplayer:exoplayer-core:$exoplayer_version"
    }

    object Koin {
        private const val version = "2.1.5"

        const val core = "org.koin:koin-core:$version"
        const val android = "org.koin:koin-android:$version"
        const val viewmodel = "org.koin:koin-android-viewmodel:$version"
    }

    object Room {
        private const val version = "2.2.2"

        const val runtime = "androidx.room:room-runtime:$version"
        const val compiler = "androidx.room:room-compiler:$version"
        const val ktx = "androidx.room:room-ktx:$version"
    }

    object Test{
        const val junit = "junit:junit:4.12"
        const val testng = "org.testng:testng:6.9.6"
    }
}
