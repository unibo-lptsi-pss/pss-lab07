# An image and text generator

Implement from scratch the TarantulaNebula application.
This very simple application requires one command-line parameter and, upon execution,
copies the files `jwst-tarantula-nebula.jpg` and `tarantula-nebula.md` into the the destination folder provided as the first command line argument.

Export the application as jar (using `./gradlew shadowJar`), and test it by launching the runnable jar.

The application must work using THE JAR ALONE (no ancillary files).

## Example usage

`java -jar tarantula-nebula.jar ciao/pluto`
Creates the folder `ciao/pluto` in the current folder (if it does not already exist),
and copies the files `jwst-tarantula-nebula.jpg` and `tarantula-nebula.md` inside it.

## Steps

1. check that at exactly one parameter has been provided
2. create a file with the provided parameter as path
3. if the file does not exist, create it as a directory (consider the `File.mkdirs()` method)
4. check that the file is a directory
5. Read the resources from the classpath
6. read these resources as a `byte[]` (consider using `InputStream.readAllBytes()`)
7. write the two `byte[]` as files in the destination folder (consider using `Files.write(Path, byte[])`)
