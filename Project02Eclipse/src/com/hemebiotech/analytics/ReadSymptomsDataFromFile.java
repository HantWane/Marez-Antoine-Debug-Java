package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for reading symptoms data from a file.
 */
public class ReadSymptomsDataFromFile implements ISymptomReader {
    private String filepath;

    /**
     * Constructs a new ReadSymptomsDataFromFile instance with the specified file path.
     * @param filepath The path to the file containing symptoms data.
     */
    public ReadSymptomsDataFromFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Reads symptoms from the file specified during object construction.
     * @return A list of symptoms read from the file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    @Override
    public List<String> readSymptoms() throws IOException {
        List<String> symptoms = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                symptoms.add(line);
            }
        }
        return symptoms;
    }
}