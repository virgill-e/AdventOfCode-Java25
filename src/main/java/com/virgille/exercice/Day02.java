package com.virgille.exercice;

import com.virgille.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day02 implements Solution {

    @Override
    public String part1(List<String> input) {
        int solve = 0;

        for (String s : input) {
            List<String> parts = Arrays.asList(s.split(" "));
            if (isSafe(parts)) {
                solve++;
            }
        }
        return String.valueOf(solve);
    }

    @Override
    public String part2(List<String> input) {
        int solve = 0;

        for (String s : input) {
            List<String> parts = Arrays.asList(s.split(" "));
            if (isSafeWithRemove(parts)) {
                solve++;
            }
        }
        return String.valueOf(solve);
    }

    private boolean isSafe(List<String> parts) {
        int num1 = Integer.parseInt(parts.get(0));
        int num2 = Integer.parseInt(parts.get(1));
        boolean isSafe = false;
        if (num1 == num2) {
            return false;
        }

        if (num1 < num2) {
            for (int i = 0; i < parts.size() - 1; i++) {
                int numTemp1 = Integer.parseInt(parts.get(i));
                int numTemp2 = Integer.parseInt(parts.get(i+1));
                isSafe = numTemp1 < numTemp2 && Math.abs(numTemp1 - numTemp2) <= 3;
                if (!isSafe) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < parts.size() - 1; i++) {
                int numTemp1 = Integer.parseInt(parts.get(i));
                int numTemp2 = Integer.parseInt(parts.get(i + 1));
                isSafe = numTemp1 > numTemp2 && Math.abs(numTemp1 - numTemp2) <= 3;
                if (!isSafe) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafeWithRemove (List<String> parts) {
        if(isSafe(parts)) {
            return true;
        }else {
            for (int i = 0; i < parts.size(); i++) {
                List<String> tempParts = new ArrayList<>(parts);
                tempParts.remove(i);
                if (isSafe(tempParts)) {
                    return true;
                }
            }
        }
        return false;
    }
}
