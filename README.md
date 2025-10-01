# Advent of Code – Java/Gradle

Ce dépôt contient mes solutions au défi Advent of Code. L’objectif est de fournir une architecture simple pour implémenter et exécuter les 25 jours de chaque édition.

## Architecture de base

- `src/main/java/com/virgille/Main.java` : point d’entrée. Il:
  - tente de charger les classes `Day01` à `Day25` depuis `com.virgille.exercice` ;
  - lit les entrées depuis `src/main/resources/day%02d.txt` (par exemple `day01.txt`) ;
  - exécute `part1` et `part2` pour chaque jour ;
  - mesure et affiche le temps d’exécution.
- `src/main/java/com/virgille/Solution.java` : contrat (interface) que chaque jour implémente.
- `src/main/java/com/virgille/exercice/DayXX.java` : implémentation d’un jour (ex: `Day01`, `Day02`, …).
- `src/main/resources/dayXX.txt` : fichier d’entrée associé au jour (ex: `day01.txt`).

## Branches = une année

Chaque branche correspond à une année d’Advent of Code.

- Exemple de nommage: `2024`, `2025`, …
- La branche contient les solutions (`Day01`…`Day25`) et les entrées de l’année.
- La branche par défaut `main` sert d’architecture/squelette réutilisable.

## Ajouter un nouveau jour

1. Créer une classe `DayXX` dans `com.virgille.exercice` qui implémente `Solution`.
2. Implémenter `part1(List<String> input)` et `part2(List<String> input)`.
3. Ajouter le fichier d’entrée `src/main/resources/dayXX.txt`.
4. Lancer `Main` pour voir les résultats et les temps d’exécution.