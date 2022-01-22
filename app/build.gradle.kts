plugins {
    kotlin("kapt")

    id("com.android.application")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "edu.bu.cs633"
        minSdk = 24
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

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
    implementation(project(":data"))
    implementation(project(":onboarding"))
    implementation(project(":authentication"))


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

        implementation(platform(FIREBASE_BOM))
        implementation(FIREBASE_ANALYTICS)
    }
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}