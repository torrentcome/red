# MyRed
![](/app/src/main/res/mipmap-hdpi/ic_launcher.png)

A sample android app that shows how to use MVVM with Coroutine & Room database with the Koin dependencies injection, in Kotlin by "Clean Architecture".

Gradle is convert to Kotlin, every `build.gradle` are `build.gradle.kts`

The Goal is to get all the Audios from the device's Provider and show it up.

### Implemented by
The structure of this project with 3 layers:
- ui
- domain
- data

### Communication between layers

1. UI calls method from ViewModel.
2. ViewModel executes internal logic.
3. Internal logic receive/save/give data from/with Repo.
4. The Repo is tied with the data (Room database here).
5. Information flows back to the UI by LiveData.

### Dependencies (in Kotlin, find it on /buildSrc)

```kotlin
        // kotlin
        implementation(Libs.Kotlin.stdlib)
        implementation(Libs.Kotlinx.couroutineCore)
        implementation(Libs.Kotlinx.couroutineAndroid)

        // androidx
        implementation(Libs.AndroidX.coreKtx)
        implementation(Libs.AndroidX.appCompat)
        implementation(Libs.AndroidX.constraintLayout)
        implementation(Libs.AndroidX.media)

        // google
        implementation(Libs.Google.material)

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
```