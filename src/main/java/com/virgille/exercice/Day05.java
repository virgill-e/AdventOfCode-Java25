package com.virgille.exercice;

import com.virgille.Solution;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day05 implements Solution {

    private static final Pattern RULES = Pattern.compile("(\\d+)\\|(\\d+)");

    @Override
    public String part1(List<String> input) {
        Map<Integer, Set<Integer>> rules = new HashMap();
        List<List<Integer>> pages = new ArrayList<>();
        int count = 0;

        putDataInCollection(input, rules, pages);

        for (List<Integer> page : pages) {
            if (pagesRespectRules(page, rules)) {
                int len = page.size();
                count += page.get(len/2);
            }
        }

        return String.valueOf(count);
    }

    @Override
    public String part2(List<String> input) {
        Map<Integer, Set<Integer>> rules = new HashMap();
        List<List<Integer>> pages = new ArrayList<>();
        int count = 0;

        putDataInCollection(input, rules, pages);

        for (List<Integer> page : pages) {
            if (!pagesRespectRules(page, rules)) {
                page.sort(comparatorFromRules(rules));
                int len = page.size();
                count += page.get(len/2);
            }
        }

        return String.valueOf(count);
    }

    private void putDataInCollection(List<String> input, Map<Integer, Set<Integer>> rules, List<List<Integer>> pages) {
        for (String line : input) {
            Matcher matcher = RULES.matcher(line);
            if (matcher.matches()) {
                int num1 = Integer.parseInt(matcher.group(1));
                int num2 = Integer.parseInt(matcher.group(2));
                rules.computeIfAbsent(num1, k -> new HashSet<>()).add(num2);
                continue;
            }
            if (line == null || line.trim().isEmpty()) continue;
            pages.add(Arrays.stream(line.split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        }
    }

    private boolean pagesRespectRules(List<Integer> pages, Map<Integer, Set<Integer>> rules){
        Set<Integer> seenBefore = new HashSet<>();

        for(Integer page : pages){
            seenBefore.add(page);
            if(!rules.containsKey(page)){continue;}
            for(int neededBefore : rules.get(page)){
                if(seenBefore.contains(neededBefore)){
                    return false;
                }
            }
        }
        return true;
    }

    private Comparator<Integer> comparatorFromRules(Map<Integer, Set<Integer>> rules) {
        return (a, b) -> {
            if (rules.getOrDefault(a, Collections.emptySet()).contains(b)) return -1;
            if (rules.getOrDefault(b, Collections.emptySet()).contains(a)) return 1;
            return 0;
        };
    }
}
