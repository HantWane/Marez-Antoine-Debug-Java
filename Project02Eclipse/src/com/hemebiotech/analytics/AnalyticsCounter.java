import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// classe représentant un compteur d'analyse des symptoms
public class AnalyticsCounter {
    private final ISymptomReader reader;
    private final ISymptomWriter writer;

	/**
     * Constructeur de la classe AnalyticsCounter.
     * @param reader Objet responsable de la lecture des symptômes.
     * @param writer Objet responsable de l'écriture des symptômes.
     */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

	// méthode pour exécuter l'analyse des symptoms
    public void runAnalysis() throws IOException {
        List<String> symptoms = getSymptoms();
        Map<String, Integer> symptomCounts = countSymptoms(symptoms);
        Map<String, Integer> sortedSymptoms = sortSymptoms(symptomCounts);
        writeSymptoms(sortedSymptoms);
    }

	// méthode pour obtenir la liste des symptoms
    public List<String> getSymptoms() throws IOException {
        return reader.readSymptoms();
    }

	        //  méthode pour compter les symptômes
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCounts = new HashMap<>();
        
        for (String symptom : symptoms) {
            symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
        }
		return symptomCounts;
    }

	        //  méthode pour trier les symptômes par ordre alphabétique
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(symptoms.entrySet());
        Collections.sort(list, Comparator.comparing(Map.Entry::getKey));
        Map<String, Integer> sortedSymptoms = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedSymptoms.put(entry.getKey(), entry.getValue());
        }
        return sortedSymptoms;
    }

	// méthode pour écrire les symptoms dans un fichier
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }

	// méthode principale pour exécuter le programme d'analyse des symptoms
    public static void main(String[] args) throws IOException {
        ISymptomReader reader = new ReadSymptomsDataFromFile("C:\\Users\\marke\\OpenClassrooms\\Projet_4\\Data\\symptoms.txt");
        ISymptomWriter writer = new WriteSymptomsDataToFile("result.out"); 

        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
        counter.runAnalysis();
    }
}
