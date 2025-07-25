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