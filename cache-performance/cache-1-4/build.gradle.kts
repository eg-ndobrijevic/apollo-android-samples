plugins {
    id("com.android.library")
    id("com.apollographql.apollo").version("1.4.5")
    kotlin("android")
}

java.sourceCompatibility = JavaVersion.VERSION_1_8

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation("com.apollographql.apollo:apollo-runtime:1.4.5")
    implementation("com.apollographql.apollo:apollo-android-support:1.4.5")
    implementation("com.apollographql.apollo:apollo-coroutines-support:1.4.5")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7")
    implementation("com.squareup.okhttp3:mockwebserver:4.7.2")

    implementation("junit:junit:4.13")
}

apollo {
    generateKotlinModels.set(true)
}

android {
    defaultConfig {
        targetSdkVersion(29)
        minSdkVersion(20)
        compileSdkVersion(29)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}