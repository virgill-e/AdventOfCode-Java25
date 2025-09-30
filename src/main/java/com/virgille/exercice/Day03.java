package com.virgille.exercice;

import com.virgille.Solution;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 implements Solution {
    private static final Pattern PATTERNPART1 = Pattern.compile("mul[\\[(](\\d+),(\\d+)[\\])]");
    private static final Pattern PATTERNPART2 = Pattern.compile(
            "mul[\\[(](\\d+),(\\d+)[\\])]|((?:do|don't))[\\[(][\\])]"
    );


    @Override
    public String part1(List<String> input) {
        int solve = 0;
        for(String s : input){
            Matcher matcher = PATTERNPART1.matcher(s);
            while (matcher.find()) {
                int num1 = Integer.parseInt(matcher.group(1));
                int num2 = Integer.parseInt(matcher.group(2));
                solve += num1 * num2;
            }
        }
        return String.valueOf(solve);
    }

    @Override
    public String part2(List<String> input) {
        int solve = 0;
        boolean enabled = true;

        for (String s : input) {
            Matcher matcher = PATTERNPART2.matcher(s);
            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    int num1 = Integer.parseInt(matcher.group(1));
                    int num2 = Integer.parseInt(matcher.group(2));
                    if (enabled) {
                        solve += num1 * num2;
                    }
                } else if (matcher.group(3) != null) {
                    String control = matcher.group(3);
                    enabled = "do".equals(control);
                }
            }
        }

        return String.valueOf(solve);
    }
}
