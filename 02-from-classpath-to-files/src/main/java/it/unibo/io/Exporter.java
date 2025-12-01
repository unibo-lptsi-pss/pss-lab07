package it.unibo.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;

/**
 * Utility to export resources into files.
 */
public final class Exporter {

    private Exporter() { }

    /**
     * Reads a resource and writes it into a destination file.
     *
     * @param resource data source in URL format (works with getResource())
     * @param destination file where the data source will be copied
     */
    public static void exportResourceAs(final URL resource, final File destination) {
        try (
            InputStream resourceStream = resource.openStream();
            BufferedInputStream in = new BufferedInputStream(resourceStream)
        ) {
            Files.write(destination.toPath(), in.readAllBytes());
        } catch (final IOException e) {
            throw new IllegalStateException(e); // Rethrow, always preserve the stacktrace!
        }
    }
}
