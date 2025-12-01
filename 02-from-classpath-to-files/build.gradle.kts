plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.159.0"
    id("com.gradleup.shadow") version "9.2.2"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.io.TarantulaNebula")
}
