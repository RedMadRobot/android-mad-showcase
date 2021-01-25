private object DataVersions {
    const val COROUTINES = "1.4.2"
    const val APOLLO = "2.4.5"
}

object DomainDependency {

    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${DataVersions.COROUTINES}"
    const val COROUTINES_ANDROID= "org.jetbrains.kotlinx:kotlinx-coroutines-android:${DataVersions.COROUTINES}"

    const val APOLLO_GRAPHQL = "com.apollographql.apollo:apollo-runtime:${DataVersions.APOLLO}"
    const val APOLLO_COROUTINES= "com.apollographql.apollo:apollo-coroutines-support:${DataVersions.APOLLO}"
}
