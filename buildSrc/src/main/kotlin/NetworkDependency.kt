private object NetworkVersions {
    const val APOLLO = CoreVersions.APOLLO
}

object NetworkDependency {
    const val APOLLO_GRAPHQL = "com.apollographql.apollo:apollo-runtime:${NetworkVersions.APOLLO}"
    const val APOLLO_COROUTINES = "com.apollographql.apollo:apollo-coroutines-support:${NetworkVersions.APOLLO}"
}
