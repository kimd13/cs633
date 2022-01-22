object Version {
    // Check out releases here https://github.com/google/dagger/releases
    const val HILT = "2.40.5"

    // Check out releases here https://developer.android.com/jetpack/androidx/releases/hilt=
    const val HILT_COMPOSE_NAVIGATION = "1.0.0-rc01"

    // Check out releases here https://developer.android.com/jetpack/androidx/releases/compose
    const val COMPOSE = "1.0.5"

    // Check out releases here https://androidx.tech/artifacts/activity/activity-compose/
    const val COMPOSE_ACTIVITY = "1.4.0"

    // Check out releases here https://developer.android.com/jetpack/compose/navigation
    const val COMPOSE_NAVIGATION = "2.4.0-rc01"

    // Check out releases here https://github.com/google/accompanist/tree/main/pager
    const val COMPOSE_ACCOMPANIST_PAGER = "0.19.0"

    // Check out releases here https://developer.android.com/jetpack/androidx/releases/lifecycle
    const val LIFECYCLE = "2.4.0"

    // Check out releases here https://maven.google.com/web/index.html#com.google.android.material:material
    const val MATERIAL = "1.4.0"

    // Check out releases here https://firebase.google.com/support/release-notes/android
    const val FIREBASE_BOM = "29.0.3"

    // Check out releases here https://developers.google.com/android/guides/google-services-plugin
    const val GOOGLE_SERVICES = "4.3.10"

    // Check out releases here https://developer.android.com/jetpack/androidx/releases/core
    const val CORE = "1.7.0"

    const val GRADLE = "7.0.1"
    const val GRADLE_KOTLIN_PLUGIN = "1.5.31"
}

object Dependency {
    const val CORE_ANDROID = "androidx.core:core-ktx:${Version.CORE}"

    const val LIFECYCLE_VIEWMODEL =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.LIFECYCLE}"
    const val LIFECYCLE_VIEWMODEL_SAVED_STATE =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Version.LIFECYCLE}"
    const val LIFECYCLE_LIVE_DATA =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Version.LIFECYCLE}"

    const val MATERIAL = "com.google.android.material:material:${Version.MATERIAL}"

    const val COMPOSE_UI = "androidx.compose.ui:ui:${Version.COMPOSE}"
    const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${Version.COMPOSE}"
    const val COMPOSE_FOUNDATION =
        "androidx.compose.foundation:foundation:${Version.COMPOSE}"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Version.COMPOSE}"
    const val COMPOSE_MATERIAL_ICONS =
        "androidx.compose.material:material-icons-core:${Version.COMPOSE}"
    const val COMPOSE_MATERIAL_ICONS_EXTENDED =
        "androidx.compose.material:material-icons-extended:${Version.COMPOSE}"
    const val COMPOSE_LIVE_DATA =
        "androidx.compose.runtime:runtime-livedata:${Version.COMPOSE}"
    const val COMPOSE_ACTIVITY =
        "androidx.activity:activity-compose:${Version.COMPOSE_ACTIVITY}"
    const val COMPOSE_NAVIGATION =
        "androidx.navigation:navigation-compose:${Version.COMPOSE_NAVIGATION}"
    const val COMPOSE_ACCOMPANIST_PAGER =
        "com.google.accompanist:accompanist-pager:${Version.COMPOSE_ACCOMPANIST_PAGER}"
    const val COMPOSE_ACCOMPANIST_PAGER_INDICATORS =
        "com.google.accompanist:accompanist-pager-indicators:${Version.COMPOSE_ACCOMPANIST_PAGER}"

    const val HILT = "com.google.dagger:hilt-android:${Version.HILT}"
    const val HILT_COMPOSE_NAVIGATION =
        "androidx.hilt:hilt-navigation-compose:${Version.HILT_COMPOSE_NAVIGATION}"

    const val FIREBASE_BOM = "com.google.firebase:firebase-bom:${Version.FIREBASE_BOM}"
    const val FIREBASE_ANALYTICS = "com.google.firebase:firebase-analytics"
    const val FIREBASE_AUTHENTICATION = "com.google.firebase:firebase-auth-ktx"
}

object TestDependency {}

object KaptDependency {
    const val HILT = "com.google.dagger:hilt-android-compiler:${Version.HILT}"
}

object ClasspathDependencies {
    const val GRADLE = "com.android.tools.build:gradle:${Version.GRADLE}"
    const val GRADLE_KOTLIN_PLUGIN =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.GRADLE_KOTLIN_PLUGIN}"

    const val HILT = "com.google.dagger:hilt-android-gradle-plugin:${Version.HILT}"

    const val GOOGLE_SERVICES = "com.google.gms:google-services:${Version.GOOGLE_SERVICES}"
}