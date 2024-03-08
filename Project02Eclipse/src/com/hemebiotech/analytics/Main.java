import java.util.Map;

/**
 * Main class to execute the symptom analysis program.
 */
public class Main {
    /**
     * Main method to execute the symptom analysis program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Creating the ISymptomReader object
        ISymptomReader reader = new ReadSymptomsDataFromFile("C:\\Users\\marke\\OpenClassrooms\\Projet_4\\Data\\symptoms.txt");

        // Creating the ISymptomWriter object
        ISymptomWriter writer = new WriteSymptomsDataToFile("result.out");

        try {
            // Creating the AnalyticsCounter object with appropriate references
            AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

            // Executing the operations in the correct order
            Map<String, Integer> sortedSymptoms = counter.runAnalysis();

            // Using the sortedSymptoms method
            System.out.println("Sorted Symptoms: " + sortedSymptoms);
        } catch (Exception e) {
            System.err.println("An error occurred during symptom analysis: " + e.getMessage());
        }
    }
}