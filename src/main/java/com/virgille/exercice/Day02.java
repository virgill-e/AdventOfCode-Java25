package com.virgille.exercice;

import com.virgille.Solution;

import java.util.ArrayList;
import java.util.List;

public class Day02 implements Solution {

    @Override
    public String part1(List<String> input) {
        int solve = 0;

        for(String s : input){
            String[] parts = s.split(" ");
            int num1 = Integer.parseInt(parts[0]);
            int num2 = Integer.parseInt(parts[1]);
            boolean isSafe = false;
            if(num1 < num2){
                for(int i = 0; i<parts.length-1; i++){
                    int numTemp1 = Integer.parseInt(parts[i]);
                    int numTemp2 = Integer.parseInt(parts[i+1]);
                    isSafe = numTemp1 < numTemp2 && Math.abs(numTemp1-numTemp2) <=3;
                    if(!isSafe){
                        break;
                    }
                }
            } else if (num1>num2) {
                for(int i = 0; i<parts.length-1; i++){
                    int numTemp1 = Integer.parseInt(parts[i]);
                    int numTemp2 = Integer.parseInt(parts[i+1]);
                    isSafe = numTemp1 > numTemp2 && Math.abs(numTemp1-numTemp2) <=3;
                    if(!isSafe){
                        break;
                    }
                }
            }

            if(isSafe){
                solve++;
            }

        }
        return String.valueOf(solve);
    }

    @Override
    public String part2(List<String> input) {
        return "";
    }
}
