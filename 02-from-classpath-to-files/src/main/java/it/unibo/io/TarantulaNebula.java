package it.unibo.io;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static java.lang.ClassLoader.getSystemResource;

/**
 * Application entry point.
 */
public final class TarantulaNebula {

    private static final String RESOURCE_PATH = "it/unibo/io/";

    private TarantulaNebula() { }

    /**
     * Application entry point. Creates documentation about the Tarantula Nebula in the target folder.
     *
     * @param args one mandatory argument representing the destination path
     */
    public static void main(final String[] args) {
        if (args.length != 1) {
            System.out.println(// NOPMD
                "This application requires exactly one parameter (the destination directory) to work, but "
                    + args.length
                    + " were provided instead"
                    + (args.length == 0 ? "." : ": " + Arrays.asList(args))
            );
            System.exit(1);
        }
        final File destination = new File(args[0]);
        if (!destination.exists() && !destination.mkdirs()) {
            System.out.println("Cannot create folder " + destination.toPath()); // NOPMD
            System.exit(2);
        }
        if (destination.isFile()) {
            System.out.println(destination.toPath() + " is a file, not a directory!");  // NOPMD
            System.exit(3);
        }
        for (final var resourceName: List.of("jwst-tarantula-nebula.jpg", "tarantula-nebula.md")) {
            Exporter.exportResourceAs(
                getSystemResource(RESOURCE_PATH + resourceName),
                new File(destination + File.separator + resourceName)
            );
        }
    }
}
