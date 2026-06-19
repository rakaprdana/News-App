import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("org.jetbrains.kotlin.plugin.parcelize")
}

android {
    namespace = "com.example.news_app"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.news_app"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        //Setup API KEY SECURITY
        //load the values from .properties file
//        val keystoreFile = project.rootProject.file("apikey.properties")
//        val properties = Properties()
//        properties.load(keystoreFile.inputStream())
//
//        //return empty key in case something goes wrong
//        val apiKey = properties.getProperty("API_KEY") ?: ""
//        buildConfigField("String", "API_KEY", "\"155c93d449764055bf9f26304482b952\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures{
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.gson)

    implementation(libs.glide)
//    implementation(libs.glide.compiler)

    implementation(libs.androidx.lifecycle.viewmodel.android)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}