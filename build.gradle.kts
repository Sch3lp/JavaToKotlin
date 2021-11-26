plugins {
    id("kotlin-conventions")
}

dependencies {

    implementation("org.apache.commons:commons-lang3:3.10") //for ValueObject

    testImplementation("org.junit.jupiter:junit-jupiter:5.8.0")
    testImplementation("org.assertj:assertj-core:3.20.2")
}

repositories {
    mavenCentral()
}
