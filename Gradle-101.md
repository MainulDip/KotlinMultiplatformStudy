### Gradle 101:
In android studio gradle comes with multi module architecture configuration.

For multi module setup, there is only one root `build.gradle`, and every module requires its own `build.gradle` file.

- `setting.gradle` is vital for setting up remote library download repository and defining the root and sub modules.


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