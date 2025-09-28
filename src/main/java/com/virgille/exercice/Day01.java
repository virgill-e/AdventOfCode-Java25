package com.virgille.exercice;

import com.virgille.Solution;

import java.util.*;

public class Day01 implements Solution {
    @Override
    public String part1(List<String> input) {
        Queue<Integer> list1 = new PriorityQueue<>();
        Queue<Integer> list2 = new PriorityQueue<>();
        for (String s : input) {
            String[] numbers = s.trim().split("\\s+");
            list1.add(Integer.parseInt(numbers[0]));
            list2.add(Integer.parseInt(numbers[1]));
        }

        int solve=0;

        Integer nb1 = null;
        Integer nb2 = null;
        while(list1.size() > 0 && list2.size() > 0){
            nb1 = (list1.size() > 0) ? list1.poll() : null;
            nb2 = (list2.size() > 0) ? list2.poll() : null;

            if(nb1 != null || nb2 != null){
                solve+=(Math.abs(nb1 - nb2));
            } else if(nb1 != null){
                solve+=nb1;
            } else if(nb2 != null){
                solve+=nb2;
            }
        }

        return String.valueOf(solve);
    }

    @Override
    public String part2(List<String> input) {
        List<Integer> list1 = new ArrayList<>();
        Map<Integer, Integer> mapList2 = new HashMap<>();
        for (String s : input) {
            String[] numbers = s.trim().split("\\s+");
            list1.add(Integer.parseInt(numbers[0]));

            if(mapList2.containsKey(Integer.parseInt(numbers[1]))){
                mapList2.put(Integer.parseInt(numbers[1]), mapList2.get(Integer.parseInt(numbers[1])) + 1);
            } else {
                mapList2.put(Integer.parseInt(numbers[1]), 1);
            }
        }

        int solve = 0;

        for(int n : list1){
            if(mapList2.containsKey(n)){
                solve+= n*mapList2.get(n);
            }
        }

        return String.valueOf(solve);
    }
}
