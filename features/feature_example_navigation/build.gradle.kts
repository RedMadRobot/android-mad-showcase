plugins {
    id("com.android.library")
    id("common-android-config")
}

dependencies {
    implementation(project(":core"))

    implementation(PresentationDependency.COMPOSE_UI)
    implementation(PresentationDependency.COMPOSE_COMPILER)
    implementation(PresentationDependency.COMPOSE_NAVIGATION)
    implementation(PresentationDependency.COMPOSE_TOOLING)
    implementation(PresentationDependency.COMPOSE_FOUNDATION)
    implementation(PresentationDependency.COMPOSE_FOUNDATION_LAYOUT)
    implementation(PresentationDependency.COMPOSE_MATERIAL)
    implementation("androidx.ui:ui-tooling:1.0.0-alpha07")
}