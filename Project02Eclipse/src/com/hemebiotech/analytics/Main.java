public class Main {
    public static void main(String[] args) {
        // Création de l'objet ISymptomReader
        ISymptomReader reader = new ReadSymptomsDataFromFile("C:\\Users\\marke\\OpenClassrooms\\Projet_4\\Data\\symptoms.txt");

        // Création de l'objet ISymptomWriter
        ISymptomWriter writer = new WriteSymptomsDataToFile("result.out");

        // Création de l'objet AnalyticsCounter
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        try {
            // Exécution des traitements dans le bon ordre
            counter.runAnalysis();
        } catch (Exception e) {
            System.err.println("Une erreur s'est produite lors de l'analyse des symptômes : " + e.getMessage());
        }
    }
}
