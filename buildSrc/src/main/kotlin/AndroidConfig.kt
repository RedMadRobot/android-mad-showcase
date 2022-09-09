object AndroidConfig {
    const val MIN_SDK_VERSION = 26
    const val COMPILE_SDK_VERSION = 33
    const val TARGET_SDK_VERSION = 33
}

interface BuildType {

    companion object {
        const val RELEASE = "release"
        const val DEBUG = "debug"
    }
}
