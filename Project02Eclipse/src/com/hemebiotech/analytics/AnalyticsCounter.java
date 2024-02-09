

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {
		// first get input
		String Directory = System.getProperty("user.dir");
		System.out.println(Directory);
		BufferedReader reader = new BufferedReader (new FileReader("Data/symptoms.txt"));
		/* 
		String line = reader.readLine();

		int i = 0;	
		int headCount = 0;	// counts headaches
		while (line != null) {
			i++;	// increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		*/
		List<String> symptoms = new ArrayList<String>();
		symptoms.add("cough");
		symptoms.add("covid");
		symptoms.add("covid");
		Map<String, Integer> MapSymptomsCount = countSymptoms(symptoms);

		System.out.println(MapSymptomsCount);
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
	private static Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCounts = new HashMap<>();

        // Parcourir tous les symptômes de la liste
        for (String symptom : symptoms) {
            // Vérifier si le symptôme est déjà présent dans la map
            if (symptomCounts.containsKey(symptom)) {
                // Si oui, incrémenter le compteur existant
                int count = symptomCounts.get(symptom);
                symptomCounts.put(symptom, count + 1);
            } else {
                // Si non, ajouter le symptôme à la map avec un compteur initialisé à 1
                symptomCounts.put(symptom, 1);
            }
        }

        return symptomCounts;
    }
}
