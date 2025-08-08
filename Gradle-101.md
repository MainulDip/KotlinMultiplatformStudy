### Gradle 101:
In android studio gradle comes with multi module architecture configuration.

For multi module setup, there is only one root `build.gradle`, and every module requires its own `build.gradle` file.

- `setting.gradle` is vital for setting up remote library download repository and defining the root and sub modules.


### Opening project using terminal | Intellij Idea | Android Studio:
When installed from Jetbrains Toolbox, each app launching shell scrip is by default generated into `~/Library/Application Support/JetBrains/Toolbox/scripts`.

`idea` for Intellij Idea, `idea1` if there are 2 version of it
`studio` for Android Studio, `studio1` if 2 version of Android Studio


`idea ./projectDirectory` will open the project in IDE 


https://www.jetbrains.com/help/idea/working-with-the-ide-features-from-command-line.html

### Intellij Idea Project Setup and Config:
If JDK mismatched, either change option in gradle build or change project settings from `file > project structure`

To change app configuration, add or edit a configuration, make sure
- JDK matches
- ClassPath `-cp` matches
- Main Class matches

### Intellij Idea more shortcuts (vvi):
`ctrl + ship + p` to show the return type of a function
`opt/alt + cmd + L` to format the code or (code > reformat)
`shift + cmd + up/down` to move code block up and down

### Kotlin named parameter and Java's non named argument:
As per kotlin docs
    When calling Java functions on the JVM, you can't use the named argument syntax because Java bytecode does not always preserve the names of function parameters.

Like `tasks.register(name = "newTask")` will not work as expected, here the named parameter function (which is a extension function from kotlin) is different than the expected java function to create a new task. So better to stay with non named parameter while writing kotlin.


### 4 terms of gradle:
- Project - usually created by `gradle init` and providing project name option in the prompt. And the project name is stored in `settings.gradle` file as `rootProject.name`

- Build Script: its the project level and module level `build.gradle.kt` file. Contains plugin, Tasks, Dependencies, plugin and task configuration.

- Tasks: Tasks are the steps performed at different stages (as configured) to build the project.

- Plugins: Plugins are to use pre-defined tasks (without re-inventing the wheel).

### Creating, adding and using new module:
In android studio, a module is same as a package/library. `file > new > new module` to create one. Once created (on an existing project), a new entry will be added in `settings.gradle` file after root project name declaration.

```kotlin
// settings.gradle
rootProject.name = "root-project-name"
include(":androidApp") // a module named `androidApp` in root directory
include(":shared") // a module named `shared` in root directory
```

The code from other module can be imported using the caller modules `build.gradle`

```kotlin
dependencies {
    implementation(projects.shared)
}
```

after this, all classes will be accessible in caller module classes


### Gradle Task:
Tasks are used to build the java/kotlin project/s. Tasks contain `actions` to build the artifact. 

Task can be created on build.gradle file or can be added using plugins. Dependencies add their own tasks to build its own artifact/output (jar). 

`./gradlew tasks` will list all root project tasks
`./gradlew module:tasks` will list the module specific tasks

`gw` can be used as shortcut for `./gradlew` if https://github.com/gdubw/gng is installed


### Gradle Task Creation and Config:
With gradle task, 3 kind of states can occurred
- Registering a task - using a task (implemented by you or provided by Gradle, Zip, Copy Delete ...) in your build logic.
- Configuring a task - defining inputs and outputs for a registered task.
- Implementing a task - creating a custom task class (i.e., custom class type).

* Creating a simple task and including into build task

```kotlin
tasks.register("hello") {
    group = "Build"
    description = "custom task description"
    println("Custom task name is $this.name")
    doLast {
        println("do last as :hello")
    }
    // dependsOn("build") // this will create circular reference error
    // as we're also configure the build task to call this task
}

// this `hello` task can be executed using 
// `./gradlew hello` or `./gradlew :module:hello`

tasks {
    build {
        dependsOn("hello")
    }
}
// after including it in build task (through configuration technique), `/.gradlew build` call will also execute the hello task

// can be written with preferred named block
tasks.named<DefaultTask>("build") {
    println("Printing from taskes.named(\"build\")")
    dependsOn("hello")
}
```



Tasks can be configured

### Gradle Task Graph


### Gradle Plugin:
Plugins encapsulate logic for specific tasks or integrations, such as compiling code, running tests, or deploying artifacts. By applying plugins, users can easily add new features to their build process without having to write complex code from scratch.

This plugin-based approach allows Gradle to be lightweight and modular. It also promotes code reuse and maintainability, as plugins can be shared across projects or within an organization.

Usually there're 3 different kinds of plugins

    1. Core Plugins - plugins that come from Gradle.

    2. Community Plugins - plugins that come from Gradle Plugin Portal or a public repository.

    3. Local or Custom Plugins - plugins that you develop yourself.

Docs: https://docs.gradle.org/current/userguide/custom_plugins.html

### Custom Gradle Plugin:
Custom plugin can be 3 types
    1. Script plugin (not recommended, but for simple task, its ok) | implemented separately in a <name>.gradle.kts file and applied using `apply(from = "<name>.gradle.kts")` from a build.gradle file

    2. Precompiled Script plugin (aka, convention plugin) | implemented inside of `buildSrc` folder or composite build

    3. Binary Plugin (a published jar file for plugin) 

* Script Plugin

```kotlin

```


### `defaultConfig`

### `flavorDimension` and `productFlavors`:

### Next & Important Note:
1. run gradle init (all 4 version). And 
    - run a java file (using java plugin)
    - use application plugin, configure and compile/run a java file

2. Complete Tom Gregory's `Get going with gradle` tutorial
3. Comeback to Phillips Gradle Ultimate
4. Build a custom gradle plugin and rebuilding kotlin gradle plugin tutorial
- How to find Gradle plugin for a specific task
- Reading a Gradle plugin (Source Code)