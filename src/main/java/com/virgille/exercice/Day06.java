package com.virgille.exercice;

import com.virgille.Solution;

import java.util.ArrayList;
import java.util.List;

public class Day06 implements Solution {
    private static final int[][] DIRECTIONS = {
            {-1, 0},  // haut
            {0, 1},   // droite
            {1, 0},   // bas
            {0, -1},  // gauche
    };

    @Override
    public String part1(List<String> input) {
        List<List<Character>> grid = new ArrayList<>();
        generateGrid(input, grid);
        int[] posS = findPos(input, '^');
        int posX = posS[0];
        int posY = posS[1];
        int dir = 0; // 0=up, 1=right, 2=down, 3=left
        int count = 1;

        while(!checkIfEnd(grid, dir, posX, posY)) {
            int[] move = DIRECTIONS[dir];
            int newX = posX + move[1];
            int newY = posY + move[0];

            if(grid.get(newY).get(newX) != '#') {
                if(grid.get(newY).get(newX) == '.'){
                    count++;
                }
                posX = newX;
                posY = newY;
                grid.get(posY).set(posX, 'X');
            }else{
                dir = (dir + 1) % 4;
            }
        }


        return String.valueOf(count);
    }

    @Override
    public String part2(List<String> input) {
        return "";
    }

    private int[] findPos(List<String> input, char c) {
        for(int row = 0; row < input.size(); row++) {
            for(int col = 0; col < input.get(row).length(); col++) {
                if(input.get(row).charAt(col) == c) {
                    return new int[]{col, row};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private void generateGrid(List<String> input, List<List<Character>> grid) {
        // Utiliser des listes mutables pour permettre l'appel à set(...)
        for (String line : input) {
            List<Character> row = new ArrayList<>(line.length());
            for (int i = 0; i < line.length(); i++) {
                row.add(line.charAt(i));
            }
            grid.add(row);
        }
    }

    private boolean checkIfEnd(List<List<Character>> grid, int dir, int posX, int posY) {
        int[] move = DIRECTIONS[dir];
        int newX = posX + move[1];
        int newY = posY + move[0];
        return newX < 0 || newX >= grid.get(0).size() || newY < 0 || newY >= grid.size();
    }
}
