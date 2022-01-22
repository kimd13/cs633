plugins {
    kotlin("kapt")

    id("com.android.library")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 24
        targetSdk = 30

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
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
    with(KaptDependency) {
        kapt(HILT)
    }

    with(Dependency) {
        implementation(CORE_ANDROID)

        implementation(HILT)
        implementation(HILT_COMPOSE_NAVIGATION)
    }
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}