package com.amir.yatzy;

/**
 * Yatzy class represente le calcule Yatzy pour une lancé de dés
 *
 * @author Amir Zghal
 *
 * @version 1.0
 */
public class Yatzy {

    public Yatzy() {
    }

    /**
     * Obtenir la chance
     *
     * @param dicesScroll le dices scroll
     * @return un int qui représente le resultat
     */
    public static int chance(DicesScroll dicesScroll)
    {
        return dicesScroll.sum();
    }

    /**
     * Obtenir le yatzy
     *
     * @param dicesScroll le dices scroll
     * @return un int qui représente le resultat
     */
    public static int yatzy(DicesScroll dicesScroll)
    {
        return dicesScroll.isYatzy() ? 50 : 0;
    }

    /**
     * Obtenir les uns
     *
     * @param dicesScroll le dices scroll
     * @return un int qui représente le resultat
     */
    public static int ones(DicesScroll dicesScroll)
    {
        return dicesScroll.countDiceMultiByDice(1);
    }

    /**
     * Obtenir les deux
     *
     * @param dicesScroll le dices scroll
     * @return un int qui représente le resultat
     */
    public static int twos(DicesScroll dicesScroll)
    {
        return dicesScroll.countDiceMultiByDice(2);
    }

    /**
     * Obtenir les trois
     *
     * @param dicesScroll le dices scroll
     * @return un int qui représente le resultat
     */
    public static int threes(DicesScroll dicesScroll)
    {
        return dicesScroll.countDiceMultiByDice(3);
    }

    /**
     * Obtenir les quatres
     *
     * @param dicesScroll le dices scroll
     * @return un int qui représente le resultat
     */
    public static int fours(DicesScroll dicesScroll)
    {
        return dicesScroll.countDiceMultiByDice(4);
    }

    /**
     * Obtenir les cinqs
     *
     * @param dicesScroll le dices scroll
     * @return un int qui représente le resultat
     */
    public static int fives(DicesScroll dicesScroll)
    {
        return dicesScroll.countDiceMultiByDice(5);
    }

    /**
     * Obtenir les six
     *
     * @param dicesScroll le dices scroll
     * @return un int qui représente le resultat
     */
    public static int sixes(DicesScroll dicesScroll)
    {
        return dicesScroll.countDiceMultiByDice(6);
    }

    /**
     * Obtenir le une paire
     *
     * @param dicesScroll le dices scroll
     * @return un int qui représente le resultat
     */
    public static int onePair(DicesScroll dicesScroll)
    {
        return dicesScroll.calculatePair(1);
    }

    /**
     * Obtenir le deux paire
     *
     * @param dicesScroll le dices scroll
     * @return un int qui représente le resultat
     */
    public static int twoPair(DicesScroll dicesScroll)
    {
        return dicesScroll.calculatePair(2);
    }

    /**
     * Obtenir le brelan
     *
     * @param dicesScroll le dices scroll
     * @return un int qui représente le resultat
     */
    public static int threeOfAKind(DicesScroll dicesScroll)
    {
        return dicesScroll.getFirstDiceWithCountGreaterThan(3) * 3;
    }

    /**
     * Obtenir le carré
     *
     * @param dicesScroll le dices scroll
     * @return un int qui représente le resultat
     */
    public static int fourOfAKind(DicesScroll dicesScroll)
    {
        return dicesScroll.getFirstDiceWithCountGreaterThan(3) * 4;
    }

    /**
     * Obtenir le small straight
     *
     * @param dicesScroll le dices scroll
     * @return un int qui représente le resultat
     */
    public static int smallStraight(DicesScroll dicesScroll)
    {
        return dicesScroll.isSmallStraight() ? 15 : 0;
    }

    /**
     * Obtenir le large straight
     *
     * @param dicesScroll le dices scroll
     * @return un int qui représente le resultat
     */
    public static int largeStraight(DicesScroll dicesScroll)
    {
        return dicesScroll.isLargeStraight() ? 20 : 0;
    }

    /**
     * Obtenir le full house
     *
     * @param dicesScroll le dices scroll
     * @return un int qui représente le resultat
     */
    public static int fullHouse(DicesScroll dicesScroll)
    {
        return dicesScroll.isFullHouse() ? dicesScroll.sum() : 0;
    }
}



