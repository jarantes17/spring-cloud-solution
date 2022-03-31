import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val pluginsVersion = "1.6.10"

    id("org.springframework.boot") version "2.6.5" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false

    kotlin("jvm") version pluginsVersion apply false
    kotlin("plugin.spring") version pluginsVersion apply false
    kotlin("plugin.jpa") version pluginsVersion apply false
}

allprojects {
    group = "cloud.example"
    version = "1.0.0"

    tasks.withType<JavaCompile> {
        sourceCompatibility = "11"
        targetCompatibility = "11"
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }
}

subprojects {
    repositories {
        mavenCentral()
    }
    apply {
        plugin("io.spring.dependency-management")
    }
}