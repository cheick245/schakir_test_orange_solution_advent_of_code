/**
 * Point d'entrée du programme.
 *
 * Ce programme lit un fichier "input.txt" contenant plusieurs rapports numériques,
 * les analyse via ma classe ReportAnalyzer, et affiche le nombre total de rapports "safe".
 */
public class Main {

    public static void main(String[] args) {

        // Nom du fichier d'entrée contenant les rapports
        String filePath = "input.txt";

        ReportAnalyzer analyzer = new ReportAnalyzer();

        System.out.println("=== Advent of Code 2024 - Day 2 ===");
        System.out.println("Analyse en cours du fichier : " + filePath);

        // J'encapsule l'appel dans un try/catch pour éviter que l'application ne plante.
        try {
            int totalReports = analyzer.countTotalReports(filePath);
            System.out.println("Nombre total de rapports : " + totalReports);

            int safeCount = analyzer.countSafeReports(filePath);

            System.out.println("Nombre de rapports safe : " + safeCount);

        } catch (Exception e) {

            // Message lisible et utile en cas de souci (fichier manquant, format incorrect, etc.)
            System.err.println("Une erreur est survenue pendant l'analyse.");
            System.err.println("Détail : " + e.getMessage());
        }
    }
}
