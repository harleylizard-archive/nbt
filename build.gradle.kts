plugins {
    `java-library`
}

group = "com.chaottic"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    api("it.unimi.dsi:fastutil:8.5.12")
}

tasks.test {
    useJUnitPlatform()
}