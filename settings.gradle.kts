rootProject.name = ("android-mad-showcase")

include(":app")

include(
    ":core:core",
    ":core:core_common",
    ":core:core_navigation",
    ":core:core_network",
    ":core:core_presentation"
)

include(
    ":features:auth",
    ":features:home"
)

