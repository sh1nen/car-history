import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.2.4.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	id("groovy")
	kotlin("jvm") version "1.3.61"
	kotlin("kapt") version "1.3.61"
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
	group = "pl.pl.stosik.car.history"
	version = "0.0.1-SNAPSHOT"

	repositories {
		mavenLocal()
		mavenCentral()
		maven { setUrl("https://dl.bintray.com/arrow-kt/arrow-kt/") }
	}
}

subprojects {
	apply(plugin = "java")
	apply(plugin = "groovy")
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "kotlin-kapt")
	apply(plugin = "org.springframework.boot")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")

	repositories {
		mavenLocal()
		google()
		jcenter()
	}

	java.sourceCompatibility = JavaVersion.VERSION_11

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-web:2.2.4.RELEASE")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.2")

		implementation(kotlin("reflect"))
		implementation(kotlin("stdlib-jdk8"))

		implementation("io.arrow-kt:arrow-core:0.10.4n")
		implementation("io.arrow-kt:arrow-syntax:0.10.4")
		kapt("io.arrow-kt:arrow-meta:0.10.4")

		implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3")
		implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:1.3.3")
		implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.3.3")

		testImplementation("junit:junit:4.12")
		testImplementation("org.codehaus.groovy:groovy-all:2.4.15")
		testImplementation("org.spockframework:spock-core:1.2-groovy-2.5")

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

	sourceSets {
		test {
			withConvention(GroovySourceSet::class) {
				groovy {
					setSrcDirs(listOf("src/test/groovy", "src/integration-test/groovy"))
					setIncludes(listOf("**/*.groovy"))
				}
			}
		}
	}
}

kapt {
	correctErrorTypes = true

	javacOptions {
		option("SomeJavacOption", "OptionValue")
	}

	arguments {
		arg("SomeKaptArgument", "ArgumentValue")
	}
}