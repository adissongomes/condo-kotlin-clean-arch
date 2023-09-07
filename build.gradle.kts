plugins {
    kotlin("jvm") version "1.9.10"
}

subprojects {
    apply(plugin = "kotlin")

    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    }

    tasks.test {
        useJUnitPlatform()
    }
}

allprojects {
    repositories {
        mavenCentral()
    }
}