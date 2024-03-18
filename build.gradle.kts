import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"

    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
    kotlin("plugin.jpa") version "1.9.22"

    id("com.vaadin") version "20.0.0"

}

group = "org.homethunder"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
    maven("https://maven.vaadin.com/vaadin-addons")
}

vaadin {
    optimizeBundle = false
    requireHomeNodeExec = true
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("com.github.mvysny.karibudsl:karibu-dsl:2.1.2")
    api("com.github.mvysny.karibu-tools:karibu-tools:0.19")

    implementation("com.vaadin:vaadin-core:24.3.6")
//    implementation("com.github.appreciated:card:2.0.0")


//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1-Beta")

//    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("org.flywaydb:flyway-core")


    implementation("com.vaadin:vaadin-spring-boot-starter")
    compileOnly("org.springframework.boot:spring-boot-devtools")

    implementation("org.postgresql:postgresql:42.7.1")
    implementation("at.favre.lib:bcrypt:0.10.2")

    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("io.jsonwebtoken:jjwt-api:0.12.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.5")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

    developmentOnly("org.springframework.boot:spring-boot-docker-compose")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencyManagement {
    imports {
        mavenBom("com.vaadin:vaadin-bom:24.3.3")
    }
}
