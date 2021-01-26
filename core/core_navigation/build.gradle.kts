plugins {
    id("com.android.library")
    id("common-android-config")
}

dependencies {
    implementation(CoreDependency.KOTLIN_STDLIB)
    implementation(PresentationDependency.COMPOSE_RUNTIME)
    implementation(PresentationDependency.COMPOSE_FOUNDATION_LAYOUT)
    implementation(PresentationDependency.COMPOSE_TOOLING)
}