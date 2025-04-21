plugins {
    id("java")
    application
    jacoco
    checkstyle
    id("org.sonarqube") version "6.0.1.5171"
    id("org.springframework.boot") version "3.3.1"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.11.4")
    implementation("org.apache.commons:commons-lang3:3.14.0")
    implementation("org.apache.commons:commons-collections4:4.4")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}

tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
    reports { xml.required.set(true) }
}
application {
    mainClass = "hexlet.code.App"
}
checkstyle {
    toolVersion = "10.12.4"
}

// Конфигурация плагина org.sonarqube
sonar {
    properties {
        property("sonar.projectKey", "brein594_java-project-78")
        property( "sonar.organization", "brein594")
        property( "sonar.host.url", "https://sonarcloud.io")
    }
}