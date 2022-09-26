plugins {
    id("java")
}

group = "ua.havrysh"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.logging.log4j:log4j-core:2.19.0")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.19.0")
    implementation("guru.nidi:graphviz-java-all-j2v8:0.18.1")
}