package com.amir.yatzy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * DiceScroll class represente la manipulation d'une lancé de dés
 *
 * @author Amir Zghal
 *
 * @version 1.0
 */
public class DicesScroll {

    private static final List<Integer> SMALL_STRAIGTH = Arrays.asList(1, 2, 3, 4, 5);
    private static final List<Integer> LARGE_STRAIGHT = Arrays.asList(2, 3, 4, 5, 6);

    private final List<Integer> dicesResults;

    /**
     * Instantiation d'un nouveau Dices scroll.
     *
     * @param dice1 le dés 1
     * @param dice2 le dés 2
     * @param dice3 le dés 3
     * @param dice4 le dés 4
     * @param dice5 le dés 5
     */
    public DicesScroll(int dice1, int dice2, int dice3, int dice4, int dice5) {
        this.dicesResults = Arrays.asList(dice1, dice2, dice3, dice4, dice5);
    }

    /**
     * la somme de tous les dés
     *
     * @return un int qui represente la somme de tous les dés
     */
    public int sum() {
        return dicesResults.stream()
            .reduce(0, Integer::sum);
    }

    /**
     * Compter les dés avec le nombre d'occurrences
     *
     * @return Un map de dés avec le nombre d'occurrences
     */
    private Map<Integer, Integer> countDices() {
        return dicesResults.stream()
            .collect(Collectors.groupingBy(d -> d, Collectors.reducing(0, e -> 1, Integer::sum)));
    }

    /**
     * Compter les occurrences de dés
     *
     * @param dice la valeur de dés à compter
     * @return un int qui represente le nombre d'occurrences pour la valeur donnée
     */
    public int countDice(int dice) {
        return countDices().getOrDefault(dice, 0);
    }

    /**
     * Compter les occurrences de dés multipliées par les dés
     *
     * @param dice la valeur de dés à compter
     * @return un int qui represente le nombre d'occurrences pour la valeur donnée multiplié par la valeur du dés
     */
    public int countDiceMultiByDice(int dice) {
        return countDice(dice) * dice;
    }

    /**
     * Obtenir un stream des dés avec un nombre supperieur à la valeur donnée
     *
     * @param count le nombre count
     * @return un stream de Integer
     */
    private Stream<Integer> getDiceValueWithCountGreaterThan(int count) {
        return countDices().entrySet().stream()
            .filter(entry -> entry.getValue() >= count)
            .map(Map.Entry::getKey);
    }

    /**
     * Trouver les paires de valeurs de dés
     *
     * @return une list de Integer qui represente liste de paires triées par valeur descendante
     */
    public List<Integer> findPairsDesc() {
        return getDiceValueWithCountGreaterThan(2)
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
    }

    /**
     * Calculer la paire par limite
     *
     * @param limit le nombre limite
     * @return un int qui représente la somme du couple limité par un limitateur et multipliée par deux
     */
    public int calculatePair(int limit) {
        List<Integer> pairs = findPairsDesc();
        if (pairs.isEmpty()) {
            return 0;
        }
        return pairs.stream().limit(limit)
            .map(pair -> pair * 2)
            .reduce(0, Integer::sum);
    }

    /**
     * Obtenir le premier dés dont le nombre est supérieur au nombre fourni
     *
     * @param count le nombre count
     * @return un int qui représente le dés dont le nombre est supérieur au nombre fourni, renvoie 0 s'il n'y a pas de correspondance
     */
    public int getFirstDiceWithCountGreaterThan(int count) {
        return getDiceValueWithCountGreaterThan(count)
            .findFirst()
            .orElse(0);
    }

    /**
     * Trier les dés par ordre croissant
     *
     * @return une list de Integer avec un ordre croissant
     **/
    private List<Integer> orderAsc() {
        return dicesResults.stream().sorted().collect(Collectors.toList());
    }

    /**
     * Deternimer si les dés sont small straight
     *
     * @return un boolean qui represente true si small straight, false sinon
     */
    public boolean isSmallStraight() {
        return orderAsc().equals(SMALL_STRAIGTH);
    }

    /**
     * Deternimer si les dés sont large straight
     *
     * @return un boolean qui represente true si large straight, false sinon
     */
    public boolean isLargeStraight() {
        return orderAsc().equals(LARGE_STRAIGHT);
    }

    /**
     * Determiner si les dés sont yatzy.
     *
     * @return un boolean qui represente true si yatzy, false sinon
     */
    public boolean isYatzy() {
        return countDices()
            .values()
            .stream()
            .anyMatch(count -> count == 5);
    }

    /**
     * Determiner si les dés sont full house
     *
     * @return un boolean qui represente true si full house, false sinon
     */
    public boolean isFullHouse() {
        int threeOfAKindValue = getFirstDiceWithCountGreaterThan(3);
        int pairValue = findPairsDesc().stream().findFirst().orElse(0);
        return threeOfAKindValue != 0 && pairValue != 0 && threeOfAKindValue != pairValue;
    }
}
