package com.amir.yatzy;


public class Yatzy {

    public Yatzy() {
    }

    public static int chance(DicesScroll dicesScroll)
    {
        return dicesScroll.sum();
    }

    public static int yatzy(DicesScroll dicesScroll)
    {
        return dicesScroll.isYatzy() ? 50 : 0;
    }

    public static int ones(DicesScroll dicesScroll)
    {
        return dicesScroll.countDiceMultiByDice(1);
    }

    public static int twos(DicesScroll dicesScroll)
    {
        return dicesScroll.countDiceMultiByDice(2);
    }

    public static int threes(DicesScroll dicesScroll)
    {
        return dicesScroll.countDiceMultiByDice(3);
    }

    public static int fours(DicesScroll dicesScroll)
    {
        return dicesScroll.countDiceMultiByDice(4);
    }

    public static int fives(DicesScroll dicesScroll)
    {
        return dicesScroll.countDiceMultiByDice(5);
    }

    public static int sixes(DicesScroll dicesScroll)
    {
        return dicesScroll.countDiceMultiByDice(6);
    }

    public static int onePair(DicesScroll dicesScroll)
    {
        return dicesScroll.calculatePair(1);
    }

    public static int twoPair(DicesScroll dicesScroll)
    {
        return dicesScroll.calculatePair(2);
    }

    public static int fourOfAKind(DicesScroll dicesScroll)
    {
        return dicesScroll.getFirstDiceWithCountGreaterThan(3) * 4;
    }

    public static int threeOfAKind(DicesScroll dicesScroll)
    {
        return dicesScroll.getFirstDiceWithCountGreaterThan(3) * 3;
    }

    public static int smallStraight(DicesScroll dicesScroll)
    {
        return dicesScroll.isSmallStraight() ? 15 : 0;
    }

    public static int largeStraight(DicesScroll dicesScroll)
    {
        return dicesScroll.isLargeStraight() ? 20 : 0;
    }

    public static int fullHouse(DicesScroll dicesScroll)
    {
        return dicesScroll.isFullHouse() ? dicesScroll.sum() : 0;
    }
}



