buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.KOTLIN}")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:${Version.KTLINT}")
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${Version.SPRING_BOOT}")
        classpath("org.jetbrains.kotlin:kotlin-allopen:${Version.KOTLIN}")
    }
}

plugins {
    kotlin("jvm") version Version.KOTLIN
}

allprojects {
    group = "io.github.yearnlune.querydsl.example"
    version = "1.0.0"

    repositories {
        mavenCentral()
        maven { url = uri("https://repo.spring.io/milestone") }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }
}

subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "jacoco")
    apply(plugin = "org.jetbrains.kotlin.kapt")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    dependencies {
        implementation(Dependency.Kotlin.REFLECT)
        implementation(Dependency.Kotlin.STDLIB)
        implementation(Dependency.Spring.VALIDATION)

        testImplementation(Dependency.Spring.TEST)
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}