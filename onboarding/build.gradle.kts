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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Version.COMPOSE
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

        implementation(LIFECYCLE_LIVE_DATA)
        implementation(LIFECYCLE_VIEWMODEL)
        implementation(LIFECYCLE_VIEWMODEL_SAVED_STATE)

        implementation(MATERIAL)

        implementation(HILT)
        implementation(HILT_COMPOSE_NAVIGATION)

        implementation(COMPOSE_UI)
        implementation(COMPOSE_TOOLING)
        implementation(COMPOSE_LIVE_DATA)
        implementation(COMPOSE_FOUNDATION)
        implementation(COMPOSE_MATERIAL)
        implementation(COMPOSE_MATERIAL_ICONS)
        implementation(COMPOSE_MATERIAL_ICONS_EXTENDED)
        implementation(COMPOSE_ACTIVITY)
        implementation(COMPOSE_NAVIGATION)
        api(COMPOSE_ACCOMPANIST_PAGER)
        api(COMPOSE_ACCOMPANIST_PAGER_INDICATORS)
    }
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}