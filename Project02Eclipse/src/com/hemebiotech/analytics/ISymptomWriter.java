package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface for writing symptoms.
 */
public interface ISymptomWriter {
    /**
     * Writes symptoms to a data destination.
     * @param symptoms A map containing symptoms and their counts.
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}