package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Class for writing symptoms data to a file.
 */
public class WriteSymptomsDataToFile implements ISymptomWriter {
    private String filepath;

    /**
     * Constructs a new WriteSymptomsDataToFile instance with the specified file path.
     * @param filepath The path to the file to write symptoms data to.
     */
    public WriteSymptomsDataToFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Writes symptoms data to the file specified during object construction.
     * @param symptoms A map containing symptoms and their counts.
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try (FileWriter writer = new FileWriter(filepath)) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing symptoms to file: " + e.getMessage());
        }
    }
}