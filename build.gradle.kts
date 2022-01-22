buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
    dependencies {
        with(ClasspathDependencies) {
            classpath(GRADLE)
            classpath(GRADLE_KOTLIN_PLUGIN)

            classpath(HILT)

            classpath(GOOGLE_SERVICES)
        }
    }
}

allprojects {
    repositories {
        maven { url = uri("https://maven.fabric.io/public") }
        maven { url = uri("https://jitpack.io") }
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}