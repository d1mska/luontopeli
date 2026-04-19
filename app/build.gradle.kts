plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.google.services)  // Tarvitaan google-services.json:lle

}
kotlin {
    jvmToolchain(21)
}


android {
    namespace = "com.example.luontopeli"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.luontopeli"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0.0"
    }

    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    // Firebase BOM – hallitsee kaikkien Firebase-kirjastojen versiot automaattisesti
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth)       // Authentication – käyttäjätunnistus
    implementation(libs.firebase.firestore)  // Firestore – löytöjen metadata pilveen

    // Guava – ratkaisee Firebase + CameraX ListenableFuture -ristiriidan
    implementation("com.google.guava:guava:32.1.3-android")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.compose.foundation)

    // Compose BOM — hallitsee Compose-kirjastojen versiot automaattisesti
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)

    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.material.icons.extended)

    // Navigation
    implementation(libs.androidx.navigation.compose)

    // Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    // OpenStreetMap
    implementation(libs.osmdroid.android)

    // CameraX
    implementation(libs.camera.core)
    implementation(libs.camera.camera2)
    implementation(libs.camera.lifecycle)
    implementation(libs.camera.view)
    implementation(libs.camera.extensions)

    // Coil
    implementation(libs.coil.compose)

    // ML Kit
    implementation(libs.mlkit.image.labeling)

    // Splash Screen
    implementation(libs.androidx.core.splashscreen)

    // Permissions
    implementation(libs.accompanist.permissions)

    // Debug Compose tools
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}