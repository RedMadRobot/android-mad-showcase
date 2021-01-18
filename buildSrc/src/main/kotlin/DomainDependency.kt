private object DomainVersions {
    const val APPCOMPAT = "1.2.0"
    const val CONSTRAINT_LAYOUT = "2.0.4"
    const val MATERIAL_UI = "1.2.1"
}

object DomainDependency {

    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${CoreVersions.COROUTINES}"
    const val COROUTINES_ANDROID= "org.jetbrains.kotlinx:kotlinx-coroutines-android:${CoreVersions.COROUTINES}"

    const val APOLLO_GRAPHQL = "com.apollographql.apollo:apollo-runtime:${CoreVersions.APOLLO}"
    const val APOLLO_COROUTINES= "com.apollographql.apollo:apollo-coroutines-support:${CoreVersions.APOLLO}"
}
