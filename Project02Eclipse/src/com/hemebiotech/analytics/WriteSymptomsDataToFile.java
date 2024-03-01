import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

// méthode pour écrire les symptoms dans le document final 
public class WriteSymptomsDataToFile implements ISymptomWriter {
    private String filepath;

    public WriteSymptomsDataToFile(String filepath) {
        this.filepath = filepath;
    }

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
