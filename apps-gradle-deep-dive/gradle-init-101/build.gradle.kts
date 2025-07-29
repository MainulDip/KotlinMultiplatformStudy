plugins {
    java
}


tasks {
    jar {
        manifest {
            attributes("Main-Class" to "MyClass")
        }
    }
}

//tasks.named("jar") {
//
//}

tasks.named<Jar>("jar") {
//    manifest {
////        attributes("Main-Class" to "MyClass")
//        attributes["Main-Class"] = "MyClass"
//    }
    manifest {

    }
}

sourceSets {
    java {

    }
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()
        }
    }
}

repositories {
    mavenCentral()
}
//
//dependencies {
//    testImplementation("org.junit.jupiter:junit-jupiter-api:5.13.4")
//}

configurations.forEach { println("${it.name}") }



//val pluginList = plugins.toList().toString()
//println("Hello Kotlin $pluginList")