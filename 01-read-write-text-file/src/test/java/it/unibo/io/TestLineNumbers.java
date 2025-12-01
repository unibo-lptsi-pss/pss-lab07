package it.unibo.io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.ClassLoader.getSystemResource;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestLineNumbers {

    @Test
    void testAddingLineNumberToPoetry() throws IOException, URISyntaxException {
        // Note how the path is relative to the **classpath**!
        // It does not matter where the file actually is, as far as is in this position in the classpath
        final URL fromClasspath = getSystemResource("it/unibo/io/dante.txt");
        final var file = new File(fromClasspath.getFile());
        LineNumbers.addLineNumbersToTextFile(file);
        final var folder = file.getParent();
        final File produced = new File(folder + File.separator + "numbered-dante.txt");
        assertTrue(produced.exists());
        assertTrue(produced.isFile());
        // Alternative to get a Path without going through a File
        final Path expected = Paths.get(getSystemResource("it/unibo/io/expected-result.txt").toURI());
        assertEquals(
            Files.readString(expected, UTF_8),
            Files.readString(produced.toPath(), UTF_8)
        );
    }
}
