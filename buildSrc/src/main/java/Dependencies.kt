object Versions {
    const val constraintlayout = "2.0.4"
    const val kotlin_version = "1.7.0"
    const val gradle_version = "7.2.0"
}

object Libs {
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val kotlinx =
        "androidx.core:core-ktx:${Versions.kotlin_version}"

    const val databinding_compiler =
        "com.android.databinding:compiler:${Versions.gradle_version}"
}