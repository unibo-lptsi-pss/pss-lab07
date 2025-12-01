package it.unibo.io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * Simple utility class that adds line numbers to files.
 */
public final class LineNumbers {

    private LineNumbers() { }

    /**
     * Processes the provided file produces a new file where each line is prefixed with its line number
     * (starting from 1).
     * The new file must have the same name of the original one, prefixed with {@code numbered-}.
     * For instance,
     * <ul>
     *     <li>{@code myfile.txt} should become {@code numbered-myfile.txt}</li>
     *     <li>{@code pluto.dat} should become {@code numbered-pluto.dat}</li>
     * </ul>
     *
     * @param file the file on which the function should operate
     * @throws IOException if something very bad happens to the file system while operating
     */
    public static void addLineNumbersToTextFile(final File file) throws IOException {
        final var lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        final var numberedLines = new ArrayList<String>(lines.size());
        for (int lineNumber = 1; lineNumber <= lines.size(); lineNumber++) {
            numberedLines.add(lineNumber + " " + lines.get(lineNumber - 1));
        }
        final var destination = new File(
            file.getParentFile().getAbsolutePath() + File.separator + "numbered-" + file.getName()
        );
        Files.write(destination.toPath(), numberedLines, StandardCharsets.UTF_8);
    }
}
