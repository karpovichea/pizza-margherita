plugins {
    id("java")
}

group = "by.itiacademy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.seleniumhq.selenium:selenium-java:4.13.0")
    testImplementation("org.testng:testng:7.6.1")
}

tasks.test {
    useTestNG()
}