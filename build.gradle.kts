plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
 implementation("com.javiersc.kotlin:kotlin-test-junit-jvm:0.1.0-alpha.15")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("junit:junit:4.13.1")

    annotationProcessor ("org.projectlombok:lombok:1.18.24")
    compileOnly ("org.projectlombok:lombok:1.18.24")

    implementation ("org.hibernate.orm:hibernate-core:6.1.0.Final")

    implementation ("org.postgresql:postgresql:42.3.8")

    implementation ("org.thymeleaf:thymeleaf:3.1.0.M2")
    compileOnly ("jakarta.servlet:jakarta.servlet-api:6.0.0")

    implementation ("com.google.code.gson:gson:2.10.1")
    implementation("org.flywaydb:flyway-core:9.20.0")
}

tasks.test {
    useJUnitPlatform()
}