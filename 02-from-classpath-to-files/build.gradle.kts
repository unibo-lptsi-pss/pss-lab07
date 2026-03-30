plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.168.0"
    id("com.gradleup.shadow") version "9.4.1"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.io.TarantulaNebula")
}
