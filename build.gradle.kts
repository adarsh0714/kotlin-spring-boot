import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.0.6"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
	kotlin("plugin.jpa") version "1.7.22"
	kotlin("kapt") version "1.7.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {

	// SPRING BOOT STARTER
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")

	// KOTLIN
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// DATABASE
	runtimeOnly("org.postgresql:postgresql")

	// DATABASE MIGRATIONS
	implementation("org.flywaydb:flyway-core")

	// TOOLS & LIBRARIES
	implementation("org.mapstruct:mapstruct:1.5.3.Final")
	kapt("org.mapstruct:mapstruct-processor:1.5.3.Final")
	kapt("org.mapstruct:mapstruct-jdk8:1.5.3.Final")

	// TEST DEPENDENCIES
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
