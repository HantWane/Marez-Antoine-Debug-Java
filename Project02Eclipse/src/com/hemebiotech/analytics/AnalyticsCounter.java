import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Class representing a symptom analysis counter.
 */
public class AnalyticsCounter {
    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    /**
     * Constructor for the AnalyticsCounter class.
     * @param reader Object responsible for reading symptoms.
     * @param writer Object responsible for writing symptoms.
     */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Method to execute symptom analysis.
     * @return A map containing sorted symptoms and their counts.
     * @throws IOException If an I/O error occurs during reading or writing symptoms.
     */
    public Map<String, Integer> runAnalysis() throws IOException {
        List<String> symptoms = getSymptoms();
        Map<String, Integer> symptomCounts = countSymptoms(symptoms);
        Map<String, Integer> sortedSymptoms = sortSymptoms(symptomCounts);
        writeSymptoms(sortedSymptoms);
        return sortedSymptoms;
    }

    /**
     * Method to obtain the list of symptoms.
     * @return A list of symptoms.
     * @throws IOException If an I/O error occurs during reading symptoms.
     */
    public List<String> getSymptoms() throws IOException {
        return reader.readSymptoms();
    }

    /**
     * Method to count symptoms.
     * @param symptoms The list of symptoms to count.
     * @return A map containing symptoms and their counts.
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCounts = new HashMap<>();

        for (String symptom : symptoms) {
            symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
        }
        return symptomCounts;
    }

    /**
     * Method to sort symptoms alphabetically.
     * @param symptoms The map of symptoms to sort.
     * @return A map containing sorted symptoms and their counts.
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(symptoms.entrySet());
        Collections.sort(list, Comparator.comparing(Map.Entry::getKey));
        Map<String, Integer> sortedSymptoms = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedSymptoms.put(entry.getKey(), entry.getValue());
        }
        return sortedSymptoms;
    }

    /**
     * Method to write symptoms to a file.
     * @param symptoms The map of symptoms to write.
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }

    /**
     * Main method to execute the symptom analysis program.
     * @param args Command line arguments (not used).
     * @throws IOException If an I/O error occurs during reading or writing symptoms.
     */
    public static void main(String[] args) throws IOException {
        ISymptomReader reader = new ReadSymptomsDataFromFile("C:\\Users\\marke\\OpenClassrooms\\Projet_4\\Data\\symptoms.txt");
        ISymptomWriter writer = new WriteSymptomsDataToFile("result.out");

        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
        counter.runAnalysis();
    }
}