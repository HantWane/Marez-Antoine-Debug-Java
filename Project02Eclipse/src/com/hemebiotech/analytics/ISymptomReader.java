package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;

/**
 * Interface for reading symptoms.
 */
public interface ISymptomReader {
    /**
     * Reads symptoms from a data source.
     * @return A list of symptoms.
     * @throws IOException If an I/O error occurs during reading.
     */
    List<String> readSymptoms() throws IOException;

    /** 
     * Reads symptoms from a CSV file
     * @return A list of symptoms
     * @throws IOException If an I/O error occurs durinf reading
     */
    List<String> readCsvSymptoms(char delimiter) throws IOException;
}