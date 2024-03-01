import java.io.IOException;
import java.util.List;

// implémentation interface pour la méthode de lecture des symptoms
public interface ISymptomReader {
    List<String> readSymptoms() throws IOException;
}
