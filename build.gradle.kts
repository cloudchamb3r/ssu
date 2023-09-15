import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.16-SNAPSHOT"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation ("org.springframework.boot:spring-boot-starter-web")
    implementation ("org.springframework.boot:spring-boot-starter-security")
    implementation ("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation ("org.jetbrains.kotlin:kotlin-reflect")
    runtimeOnly ("com.mysql:mysql-connector-j")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation ("org.mockito:mockito-core")
    implementation ("javax.validation:validation-api:2.0.1.Final")
    implementation ("org.hibernate.validator:hibernate-validator:6.2.0.Final")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
