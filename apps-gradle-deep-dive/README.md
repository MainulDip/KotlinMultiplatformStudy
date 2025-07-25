### Compiling and running a java file:
Java files need to be compiled into java byte code. `.class` for single file and `.jar` for multiple related files. Java Archive (jar) is kind of a zipped file contain `.class`, `MANIFEST.MF` and all kinds of files for that project, sometimes also containing the source code as well. 

* `.war` is a type of `.jar` file (for web servers), can contain `html/css/js`, databases, beans etc along with manifest.mf inside of `META-INF/` 

`.java` files are first needs to be compiled using `javac` (java compiler), and a compiled java class usually have `<name>.class` signature.

To run a compiled class (assuming it has public static void main method)
- `java CompiledClassName` will execute the file 
- `java -cp ./src/main/java CompiledClassName` when the .class file is inside of a sub-directory `src/main/java`


Creating a compiled jar file (`-cf` to create & fileName) and running
- `javac MyApp.java` | will generate MyApp.class file
- `jar -cf myJar.jar MyApp.class` | creating jar file, will package the class file as myJar.jar name
- `java -cp myJar.jar MyApp` where MyApp is the class containing the `main` static method

When the jar is inside of a sub-directory, run `java -cp ./build/libs/Gradle-Basic.jar MyClass`. Where MyClass contains the main static method

-  `-cfe` is `--create` & `--file=FILE` & `--main-class=CLASSNAME`
- `-m` is for `--manifest=FILE`
- `-cp` is same as `-classpath` or `--class-path` 

### The Main Class:
While running a jar (java archive file), the Main class should be specified either in the `java` command with `-e` flag (as `--main-class=CLASSNAME`) or in a manifest file, which needs `-jar` & `-m` flag. 

A Java manifest file, typically named `MANIFEST.MF`, is a special file within a Java Archive (JAR) file that contains metadata about the contents of the JAR. This file is located in the META-INF directory within the JAR.

```txt
Manifest-version: 1.0
Main-Class: CustomClass
```

* When there is a manifest file, `-jar` option needs to be specified, as `java -jar ./build/libs/Gradle-Basic.jar`

### Next Steps:
- Get Going With Gradle | course from Tom Gragory 
- Gradle ultimate guide | course from Phillip Lackner
- Gradle Custom Plugin | official guide