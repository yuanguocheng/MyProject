import org.gradle.api.JavaVersion

object AndroidConfig {

    const val compileSdkVersion = 32
    const val buildToolsVersion = "30.0.3"
    val defaultConfig = DefaultConfig()
    val compileOptions = CompileOptions()

    class DefaultConfig {
        val applicationId = "com.example.myproject"
        val minSdkVersion = 21
        val targetSdkVersion = 32
    }

    class CompileOptions {
        val sourceCompatibility = JavaVersion.VERSION_1_8
        val targetCompatibility = JavaVersion.VERSION_1_8
    }

}