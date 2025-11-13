import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires pour la classe ReportAnalyzer.
 * 
 * Ces tests vérifient que la méthode isSafe() fonctionne correctement
 * sur les exemples officiels donnés dans l'énoncé du problème Advent of Code.
 * 
 * Rédiger les tests AVANT d'écrire l'implémentation permet d'adopter
 * une démarche TDD (Test Driven Development) simple.
 */
public class ReportAnalyzerTest {

    /**
     * Exemple officiel : 7 6 4 2 1
     * Séquence strictement décroissante avec des pas entre 1 et 3 → SAFE.
     */
    @Test
    public void testExampleSafe() {
        ReportAnalyzer analyzer = new ReportAnalyzer();
        assertTrue(analyzer.isSafe(List.of(7, 6, 4, 2, 1)),
                "La séquence 7 6 4 2 1 devrait être considérée comme sûre.");
    }

    /**
     * Exemple officiel : 1 2 7 8 9
     * Le pas 2 → 7 = +5 (supérieur à 3) → UNSAFE.
     */
    @Test
    public void testExampleUnsafeBigJump() {
        ReportAnalyzer analyzer = new ReportAnalyzer();
        assertFalse(analyzer.isSafe(List.of(1, 2, 7, 8, 9)),
                "La séquence 1 2 7 8 9 devrait être considérée comme non sûre.");
    }

    /**
     * Exemple officiel : 9 7 6 2 1
     * Le pas 6 → 2 = -4 (inférieur à -3) → UNSAFE.
     */
    @Test
    public void testExampleUnsafeDecreaseTooLarge() {
        ReportAnalyzer analyzer = new ReportAnalyzer();
        assertFalse(analyzer.isSafe(List.of(9, 7, 6, 2, 1)),
                "La séquence 9 7 6 2 1 devrait être considérée comme non sûre.");
    }

    /**
     * Exemple officiel : 1 3 2 4 5
     * Change de direction (monte puis descend) → UNSAFE.
     */
    @Test
    public void testExampleUnsafeDirectionChange() {
        ReportAnalyzer analyzer = new ReportAnalyzer();
        assertFalse(analyzer.isSafe(List.of(1, 3, 2, 4, 5)),
                "La séquence 1 3 2 4 5 devrait être considérée comme non sûre.");
    }

    /**
     * Exemple officiel : 8 6 4 4 1
     * 4 → 4 = égal → UNSAFE.
     */
    @Test
    public void testExampleUnsafeEqualValues() {
        ReportAnalyzer analyzer = new ReportAnalyzer();
        assertFalse(analyzer.isSafe(List.of(8, 6, 4, 4, 1)),
                "La séquence 8 6 4 4 1 devrait être considérée comme non sûre.");
    }

    /**
     * Exemple officiel : 1 3 6 7 9
     * Séquence strictement croissante avec des pas entre 1 et 3 → SAFE.
     */
    @Test
    public void testExampleSafeIncreasing() {
        ReportAnalyzer analyzer = new ReportAnalyzer();
        assertTrue(analyzer.isSafe(List.of(1, 3, 6, 7, 9)),
                "La séquence 1 3 6 7 9 devrait être considérée comme sûre.");
    }
}
