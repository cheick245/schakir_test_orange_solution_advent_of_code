import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReportAnalyzer {

   
/**
 * Détermine si une suite de niveaux est "safe" selon les règles du puzzle.
 * 
 * Une suite est safe si :
 *  - elle est entièrement croissante OU entièrement décroissante ;
 *  - la différence entre deux valeurs consécutives est toujours comprise entre 1 et 3 ;
 *  - il n'y a jamais deux valeurs égales.
 * 
 */
public boolean isSafe(List<Integer> levels) {

    // Une suite trop courte ne peut pas être incorrecte
    if (levels.size() <= 1) {
        return true;
    }

    // Calcul du premier écart pour déterminer la tendance générale
    int firstDiff = levels.get(1) - levels.get(0);

    if (firstDiff == 0) {
        return false;   // égalité interdite
    }

    boolean isIncreasing = firstDiff > 0;

    // Parcours de la liste pour vérifier la cohérence de la suite
    for (int i = 1; i < levels.size(); i++) {

        int diff = levels.get(i) - levels.get(i - 1);

        // Deux valeurs égales => automatiquement non safe
        if (diff == 0) {
            return false;
        }

        // Vérification de la direction : toute la suite doit aller dans le même sens
        if (isIncreasing && diff < 0) {
            return false;
        }
        if (!isIncreasing && diff > 0) {
            return false;
        }

        // Vérification de l'amplitude du pas (obligatoirement entre 1 et 3)
        int step = Math.abs(diff);
        if (step < 1 || step > 3) {
            return false;
        }
    }

    // Si aucune règle n'a été enfreinte, la suite est safe
    return true;
}


/**
 * Analyse un fichier contenant plusieurs rapports (un par ligne)
 * et retourne le nombre total de rapports "safe".
 */
public int countSafeReports(String filePath) {
    try {

        // Lecture du fichier ligne par ligne
        return (int) Files.lines(Path.of(filePath))
                .map(String::trim)
                .filter(line -> !line.isEmpty())       // ignore les lignes vides
                .map(this::parseLine)                  // conversion
                .filter(this::isSafe)                  // application de la logique
                .count();

    } catch (IOException e) {
        System.err.println("Erreur lors de la lecture du fichier : " + filePath);
        System.err.println("Détail : " + e.getMessage());

        // On retourne 0 par sécurité, mais on ne bloque pas l'application
        return 0;
    }
    
}
/**
 * Convertit une ligne comme "7 6 4 2 1" en une liste d'entiers.
 */
private List<Integer> parseLine(String line) {
    return List.of(line.split(" ")).stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
}

/**
 * Retourne le nombre total de rapports présents dans le fichier.
 * (Chaque ligne non vide est considérée comme un rapport.)
 */
public int countTotalReports(String filePath) {
    try {
        return (int) Files.lines(Path.of(filePath))
                .filter(line -> !line.trim().isEmpty())
                .count();
    } catch (IOException e) {
        System.err.println("Impossible de lire le fichier : " + filePath);
        System.err.println("Détail : " + e.getMessage());
        return 0;
    }
}

}
