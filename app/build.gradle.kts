import com.android.build.gradle.internal.dsl.decorator.SupportedPropertyType.Collection.List.type
import org.gradle.internal.impldep.org.eclipse.jgit.lib.InflaterCache.release

plugins {
    id("com.android.library")
    `maven-publish`
}

tasks.register<Jar>("generateSourcesJar") {
    from(android.sourceSets.getByName("main").java.srcDirs)
    archiveClassifier.set("sources")
}


android {
    namespace = "com.safetyprotection"
    compileSdk = 34

    defaultConfig {
        minSdk = 28
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

android {
    publishing {
        singleVariant("release")
    }
}
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                // 如果是 Android 库，使用 `from(components["release"])`
                // 如果是 Java 库，使用 `from(components["java"])`
                groupId = "com.safetyprotection"  // 依赖库的组 ID
                artifactId = "SafetyProtection"        // 依赖库的名称
                version = "1.0.0"                // 当前版本依赖库版本号

                // 可以添加其他配置，如 pom 信息
            }
        }
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    // firebase
    api(platform("com.google.firebase:firebase-bom:32.7.0"))
    api("com.google.firebase:firebase-analytics")
    // appsflyer
    api("com.appsflyer:af-android-sdk:6.12.5")
    // Google Location Services
    api("com.google.android.gms:play-services-location:21.0.1")
    api ("pub.devrel:easypermissions:3.0.0")
    // 网络
    api ("com.squareup.okhttp3:okhttp:4.12.0")
    api ("dnsjava:dnsjava:3.4.2")


}