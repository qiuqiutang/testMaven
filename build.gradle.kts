// Top-level build file where you can add configuration options common to all sub-projects/modules.
allprojects {
    extra["publishGroupId"] = "com.example.modulea"
    extra["publishVersion"] = "1.0.0"
}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
}