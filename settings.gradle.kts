rootProject.name = ("android-mad-showcase")

include(":app")

include(
    ":core:core",
    ":core:core_navigation",
    ":core:core_network",
    ":core:core_presentation"
)

include(
    "base:base_cards"
)

include(
    ":features:auth",
    ":features:home",
    ":features:details"
)
