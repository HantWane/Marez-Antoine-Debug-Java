import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// méthode pour lire le document des symptoms
public class ReadSymptomsDataFromFile implements ISymptomReader {
    private String filepath;

    public ReadSymptomsDataFromFile(String filepath) {
        this.filepath = filepath;
    }

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
