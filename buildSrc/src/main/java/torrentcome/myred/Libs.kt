
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

    object Test{
        const val junit = "junit:junit:4.12"
        const val junitJupiter = "org.junit.jupiter:junit-jupiter"
        const val testng = "org.testng:testng:6.9.6"
    }
}
