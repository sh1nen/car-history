import org.gradle.kotlin.dsl.exclude

object Dependencies {
    const val slf4j = "org.slf4j:slf4j-simple:${Versions.slf4j}"
    const val h2 = "com.h2database:h2:${Versions.h2}"
    const val jacksonCore = "com.fasterxml.jackson.core:jackson-databind:${Versions.jacksonCore}"
    const val jacksonModule = "com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.jacksonModule}"
    const val junitJupiterApi = "org.junit.jupiter:junit-jupiter-api"
    const val junitJupiterEngine = "org.junit.jupiter:junit-jupiter-engine"

    val Spring = SpringDependencies
    val Kotlin = KotlinDependencies
    val Arrow = ArrowDependencies
    val Test = TestDependencies
}

object SpringDependencies {
    const val bootStarter = "org.springframework.boot:spring-boot-starter:${Versions.springBoot}"
    const val bootWebStarter = "org.springframework.boot:spring-boot-starter-web:${Versions.springBoot}"
    const val bootActuator = "org.springframework.boot:spring-boot-starter-actuator:${Versions.springBoot}"
    const val bootDataJpa = "org.springframework.boot:spring-boot-starter-data-jpa:${Versions.springBoot}"
    const val undertow = "org.springframework.boot:spring-boot-starter-undertow:${Versions.springBoot}"
}

object KotlinDependencies {
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    const val coroutinesReactive = "org.jetbrains.kotlinx:kotlinx-coroutines-reactive:${Versions.kotlinCoroutines}"
    const val coroutinesRx2 = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:${Versions.kotlinCoroutines}"

    const val jackson = "com.fasterxml.jackson.module:jackson-module-kotlin:2.10.2"

    const val logger = "io.github.microutils:kotlin-logging:${Versions.kotlinLogger}"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
}

object ArrowDependencies {
    const val arrowFx = "io.arrow-kt:arrow-fx:${Versions.arrow}"
    const val arrowMtl = "io.arrow-kt:arrow-mtl:${Versions.arrow}"
    const val arrowSyntax = "io.arrow-kt:arrow-syntax:${Versions.arrow}"
}

object TestDependencies {
    const val spock = "org.spockframework:spock-core:${Versions.Test.spock}"
    const val spockReports = "com.athaydes:spock-reports:${Versions.Test.spockReports}"
    const val junit = "junit:junit:4.12"
    const val groovyAll = "org.codehaus.groovy:groovy-all:2.4.15"
    const val groovy = "org.spockframework:spock-core:1.2-groovy-2.5"
    const val springTest = "org.springframework.boot:spring-boot-starter-test:${Versions.springBoot}"
}

const val implementation = "implementation"
const val testImplementation = "testImplementation"
const val runtime = "runtime"