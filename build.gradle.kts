plugins {
    id("java")
}

group = "com.patryk"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.25.0")

    // 1. Mechanizm budowania WebDriver
    implementation(dependencyNotation = "io.github.bonigarcia:webdrivermanager:5.5.3")

    // w razie problemów z bibliotek? logowania SLF4J
    implementation(dependencyNotation = "ch.qos.logback:logback-classic:1.4.11")
    // + zaktualizuj zale?no?ci przez PowerShell:
    // .\gradlew dependencies --refresh-dependencies

}

tasks.test {
    useJUnitPlatform()
}