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
//    maven { url = "https://maven.vaadin.com/vaadin-addons" }
}
//
//vaadin {
//    optimizeBundle = false
//}


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    val exposedVersion = "0.47.0"

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("com.github.mvysny.karibudsl:karibu-dsl:2.1.2")
    api("com.github.mvysny.karibu-tools:karibu-tools:0.19")

    implementation("com.vaadin:vaadin-core:24.3.3")

//    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")


    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-crypt:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")

    implementation("org.jetbrains.exposed:exposed-kotlin-datetime:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-json:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-spring-boot-starter:$exposedVersion")

    implementation("org.flywaydb:flyway-core")


    implementation("com.vaadin:vaadin-spring-boot-starter")
    compileOnly("org.springframework.boot:spring-boot-devtools")
    implementation("io.konform:konform-jvm:0.4.0")

    implementation("org.postgresql:postgresql:42.7.1")
    implementation("at.favre.lib:bcrypt:0.10.2")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

//    implementation(kotlin("kotlin-stdlib-jdk8"))
//    runtimeOnly("org.postgresql:postgresql")

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
