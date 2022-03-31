plugins {
    id("org.springframework.boot")
    kotlin("jvm")
    kotlin("plugin.spring")
}

allprojects {
    group = "cloud.example"
    version = "1.0.0"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-server:3.1.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.5")
}

repositories {
    mavenCentral()
}

tasks.register("prepareKotlinBuildScriptModel"){}