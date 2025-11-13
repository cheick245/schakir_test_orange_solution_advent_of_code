# schakir_test_orange_solution_advent_of_code

Solution personnelle à l’exercice dans le cadre du processus de recrutement Orange


## Analyse de rapports – Implémentation en Java

Ce projet propose une implémentation complète du puzzle **Advent of Code 2024 – Jour 2**, consistant à analyser une liste de rapports numériques afin de déterminer lesquels sont *safe* selon des règles précises.



## 📌 Règles d’un rapport *safe*

Un rapport (suite de nombres séparés par espaces) est considéré comme **safe** si :

1. La suite est **strictement croissante** ou **strictement décroissante**  
2. Chaque différence entre deux valeurs consécutives est **entre 1 et 3 inclus**  
3. Aucun couple de valeurs consécutives n’est égal

Exemples provenant de l’énoncé :
- `7 6 4 2 1` → Safe  
- `1 2 7 8 9` → Unsafe (+5 interdit)  
- `9 7 6 2 1` → Unsafe (-4 interdit)  
- `1 3 2 4 5` → Unsafe (changement de direction)  
- `8 6 4 4 1` → Unsafe (valeurs égales)  
- `1 3 6 7 9` → Safe  

---

## 🛠️ Structure du projet

.
├── input.txt # Données à analyser
├── pom.xml # Configuration Maven
├── README.md
└── src/
├── main/java/
│ ├── Main.java # Point d'entrée
│ └── ReportAnalyzer.java # Logique de vérification + analyse fichier
└── test/java/
└── ReportAnalyzerTest.java # Tests unitaires JUnit


---

## ▶️ Exécution du programme

Placer le fichier `input.txt` à la racine du projet puis exécuter :

```bash
mvn -q exec:java
Exemple de sortie :

yaml
Copier le code
=== Résultat ===
Analyse du fichier : input.txt

Nombre total de rapports : 1000
Nombre de rapports safe  : 328


 Tests unitaires
Pour exécuter les tests :

bash
Copier le code
mvn test
Les tests couvrent les exemples officiels de l’énoncé afin de garantir la conformité de la méthode isSafe().

✔ Implémentation
La classe ReportAnalyzer contient :

isSafe(List<Integer>) : Vérifie la sécurité d’un rapport (logique complète de l’énoncé)

countSafeReports(String) : Analyse un fichier entier, gère les erreurs et retourne le nombre de rapports safe

countTotalReports(String) : Compte le nombre total de rapports valides dans un fichier



 Auteur
Développé par Kagoné Cheick Schakir
Dans le cadre d’un exercice d’évaluation technique.

yaml
