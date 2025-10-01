package com.virgille.exercice;

import com.virgille.Solution;

import java.util.List;

public class Day04 implements Solution {
    private static final int[][] ALLDIRECTIONS = {
            {0, 1},   // droite
            {1, 0},   // bas
            {0, -1},  // gauche
            {-1, 0},  // haut
            {1, 1},   // diagonale bas droite
            {1, -1},  // diagonale bas gauche
            {-1, 1},  // diagonale haut droite
            {-1, -1}  // diagonale haut gauche
    };

    @Override
    public String part1(List<String> input) {
        int found = 0;
        for(int row = 0; row < input.size(); row++) {
            for(int col = 0; col < input.get(row).length(); col++) {
                found += countWordsInPos(input, "XMAS", row, col);
            }
        }

        return String.valueOf(found);
    }

    @Override
    public String part2(List<String> input) {
        int count = 0;
        for(int row = 0; row < input.size(); row++) {
            for(int col = 0; col < input.get(row).length(); col++) {
                if(isCrossMass(input, row, col)) {
                    count++;
                }
            }
        }
        return String.valueOf(count);
    }

    private int countWordsInPos(List<String> grid, String word, int row, int col) {
        if(grid.get(row).charAt(col) != word.charAt(0)) {
            return 0;
        }
        int count = 0;
        for (int[] dir : ALLDIRECTIONS) {
            int r = row, c = col;
            int i;
            for (i = 0; i < word.length(); i++) {
                if (r < 0 || r >= grid.size() || c < 0 || c >= grid.get(r).length() || grid.get(r).charAt(c) != word.charAt(i)) {
                    break;
                }
                r += dir[0];
                c += dir[1];
            }
            if (i == word.length()) {
                count++;
            }
        }
        return count;
    }

    private boolean isCrossMass(List<String> grid, int row, int col) {
        if(grid.get(row).charAt(col) != 'A') {return false;}
        //valider si pos dans la grille
        if(row - 1 < 0 || row + 1 >= grid.size() || col - 1 < 0 || col + 1 >= grid.get(row).length()) {
            return false;
        }
        boolean result1 = false;
        boolean result2 = false;


        if(grid.get(row + 1).charAt(col + 1) == 'M' || grid.get(row + 1).charAt(col + 1) == 'S') {
            if(grid.get(row - 1).charAt(col - 1) == 'M' || grid.get(row - 1).charAt(col - 1) == 'S') {
                if(grid.get(row + 1).charAt(col + 1) != grid.get(row - 1).charAt(col - 1)) {
                    result1 = true;
                }
            }
        }

        if(grid.get(row + 1).charAt(col - 1) == 'M' || grid.get(row + 1).charAt(col - 1) == 'S') {
            if(grid.get(row - 1).charAt(col + 1) == 'M' || grid.get(row - 1).charAt(col + 1) == 'S') {
                if(grid.get(row + 1).charAt(col - 1) != grid.get(row - 1).charAt(col + 1)) {
                    result2 = true;
                }
            }
        }

        return result1 && result2;

    }

}
