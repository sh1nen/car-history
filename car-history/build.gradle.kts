import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.2.4.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("jvm") version "1.3.61"
	kotlin("plugin.spring") version "1.3.61"
}

buildscript {
	repositories {
		mavenCentral()
	}
	dependencies {
		classpath("org.springframework.boot:spring-boot-gradle-plugin:2.1.3.RELEASE")
		classpath("io.spring.gradle:dependency-management-plugin:1.0.6.RELEASE")
	}
}

allprojects {
	group = "pl.stosik.car.history"
	version = "0.0.1-SNAPSHOT"

	repositories {
		mavenLocal()
		mavenCentral()
	}
}

subprojects {
	apply(plugin = "java")
	apply(plugin = "org.springframework.boot")
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")

	repositories {
		mavenLocal()
		mavenCentral()
		google()
		jcenter()
	}

	java.sourceCompatibility = JavaVersion.VERSION_11

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-web:2.2.4.RELEASE")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.2")

		implementation(kotlin("reflect"))
		implementation(kotlin("stdlib-jdk8"))

		implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3")
		implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:1.3.3")
		implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.3.3")

		testImplementation("org.springframework.boot:spring-boot-starter-test:2.2.4.RELEASE") {
			exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "1.8"
		}
	}
}
