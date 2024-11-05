// Top-level build file where you can add configuration options common to all sub-projects/modules.
// tqmbahkan ini untuk pernggunan navigation pelemparan data
buildscript {
    repositories {
        google()
    }
    dependencies {
        // navigation
        classpath (libs.androidx.navigation.safe.args.gradle.plugin) // versi terbaru

    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false

}