rootProject.name = ("android-mad-showcase")
include(":app")

include(
    ":core:core",
    ":core:core_presentation",
    ":core:core_network"
)

include(
    ":features:auth",
    ":features:home"
)

