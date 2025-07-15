### Gradle 101:
In android studio gradle comes with multi module architecture configuration.

For multi module setup, there is only one root `build.gradle`, and every module requires its own `build.gradle` file.

- `setting.gradle` is vital for setting up remote library download repository and defining the root and sub modules.

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

###