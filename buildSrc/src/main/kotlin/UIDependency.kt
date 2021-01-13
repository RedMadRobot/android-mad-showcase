private object UIVersions {
    const val APPCOMPAT = "1.2.0"
    const val CONSTRAINT_LAYOUT = "2.0.4"
    const val MATERIAL_UI = "1.2.1"
}

object UIDependency {
    const val APPCOMPAT = "androidx.appcompat:appcompat:${UIVersions.APPCOMPAT}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${UIVersions.CONSTRAINT_LAYOUT}"
    const val MATERIAL_UI = "com.google.android.material:material:${UIVersions.MATERIAL_UI}"
}
