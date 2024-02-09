

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Interface pour écrire des données de symptômes vers une destination.
 */
public interface ISymptomWriter {
    /**
     * Écrire les symptômes et leurs quantités vers une destination.
     * 
     * @param symptoms Une map contenant les symptômes en tant que clés et leurs quantités en tant que valeurs.
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
