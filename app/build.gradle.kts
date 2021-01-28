plugins {
    id("com.android.application")
    id("common-android-config")
}

android {
    defaultConfig {
        applicationId = "com.redmadrobot.mad"
    }
}

dependencies {
    implementation(PresentationDependency.APPCOMPAT)
    implementation(PresentationDependency.CONSTRAINT_LAYOUT)
    implementation(PresentationDependency.MATERIAL_UI)

    implementation(PresentationDependency.COMPOSE_UI)
    implementation(PresentationDependency.COMPOSE_COMPILER)
    implementation(PresentationDependency.COMPOSE_TOOLING)
    implementation(PresentationDependency.COMPOSE_FOUNDATION)
    implementation(PresentationDependency.COMPOSE_MATERIAL)
}
