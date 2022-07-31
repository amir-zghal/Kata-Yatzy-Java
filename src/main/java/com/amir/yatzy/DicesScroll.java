package com.amir.yatzy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DicesScroll {

    private static final List<Integer> SMALL_STRAIGTH = Arrays.asList(1, 2, 3, 4, 5);
    private static final List<Integer> LARGE_STRAIGHT = Arrays.asList(2, 3, 4, 5, 6);

    private final List<Integer> dicesResults;

    public DicesScroll(int dice1, int dice2, int dice3, int dice4, int dice5) {
        this.dicesResults = Arrays.asList(dice1, dice2, dice3, dice4, dice5);
    }

    public int sum() {
        return dicesResults.stream()
            .reduce(0, Integer::sum);
    }

    private Map<Integer, Integer> countDices() {
        return dicesResults.stream()
            .collect(Collectors.groupingBy(d -> d, Collectors.reducing(0, e -> 1, Integer::sum)));
    }

    public int countDice(int dice) {
        return countDices().getOrDefault(dice, 0);
    }

    public int countDiceMultiByDice(int dice) {
        return countDice(dice) * dice;
    }

    private Stream<Integer> getDiceValueWithCountGreaterThan(int count) {
        return countDices().entrySet().stream()
            .filter(entry -> entry.getValue() >= count)
            .map(Map.Entry::getKey);
    }

    public List<Integer> findPairsDesc() {
        return getDiceValueWithCountGreaterThan(2)
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
    }

    public int calculatePair(int limit) {
        List<Integer> pairs = findPairsDesc();
        if (pairs.isEmpty()) {
            return 0;
        }
        return pairs.stream().limit(limit)
            .map(pair -> pair * 2)
            .reduce(0, Integer::sum);
    }

    public int getFirstDiceWithCountGreaterThan(int count) {
        return getDiceValueWithCountGreaterThan(count)
            .findFirst()
            .orElse(0);
    }

    private List<Integer> orderAsc() {
        return dicesResults.stream().sorted().collect(Collectors.toList());
    }

    public boolean isSmallStraight() {
        return orderAsc().equals(SMALL_STRAIGTH);
    }

    public boolean isLargeStraight() {
        return orderAsc().equals(LARGE_STRAIGHT);
    }

    public boolean isYatzy() {
        return countDices()
            .values()
            .stream()
            .anyMatch(count -> count == 5);
    }

    public boolean isFullHouse() {
        int threeOfAKindValue = getFirstDiceWithCountGreaterThan(3);
        int pairValue = findPairsDesc().stream().findFirst().orElse(0);
        return threeOfAKindValue != 0 && pairValue != 0 && threeOfAKindValue != pairValue;
    }
}
