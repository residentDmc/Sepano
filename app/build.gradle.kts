plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.sampleapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.sampleapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        //noinspection DataBindingWithoutKapt
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //circular imageview
    implementation("com.mikhaellopez:circularimageview:4.3.0")

    // navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.5")

    // koin
    implementation("org.koin:koin-android-viewmodel:2.1.6")
    implementation("org.koin:koin-android:2.1.6")

    // legacy
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    // material
    implementation("com.google.android.material:material:1.11.0-beta01")

    // multidex
    implementation("androidx.multidex:multidex:2.0.1")

    // cardView
    implementation("androidx.cardview:cardview:1.0.0")

    // recyclerview
    implementation("androidx.recyclerview:recyclerview:1.3.2")

    // lifecycle
    implementation("android.arch.lifecycle:extensions:1.1.1")

    // activity-ktx
    implementation("androidx.activity:activity-ktx:1.8.0")
    implementation("androidx.fragment:fragment-ktx:1.6.2")

    // dimens
    implementation("com.intuit.sdp:sdp-android:1.1.0")

    // bluetooth
    implementation("com.github.tlgbltcn:BluetoothHelper:v1.7")

}