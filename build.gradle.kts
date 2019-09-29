plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.50"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.3.50"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.3.50"
    id("io.quarkus") version "0.23.1"
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(enforcedPlatform("io.quarkus:quarkus-bom:0.23.1"))
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-resteasy")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.13.0")
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured:4.1.0")
}

version = "0.0.1"

quarkus {
    setSourceDir(project.projectDir.resolve("src/main/kotlin").absolutePath)
    setOutputDirectory(project.projectDir.resolve("build/classes/kotlin/main").absolutePath)
}

allOpen {
    annotation("javax.enterprise.context.ApplicationScoped")
}

tasks {
    "test"(Test::class) {
        useJUnitPlatform()
    }
}
