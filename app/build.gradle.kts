plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.calculadora"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.calculadora"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")


    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.10.0")

}

tasks.withType<Test> {
    useJUnitPlatform()
}
