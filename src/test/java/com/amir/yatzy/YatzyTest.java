package com.amir.yatzy;

import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void testChance() {
        DicesScroll dicesScroll1 = new DicesScroll(2,3,4,5,1);
        DicesScroll dicesScroll2 = new DicesScroll(3,3,4,5,1);

        assertEquals(15, Yatzy.chance(dicesScroll1));
        assertEquals(16, Yatzy.chance(dicesScroll2));
    }

    @Test public void testYatzyScores50() {
        assertEquals(50, Yatzy.yatzy(new DicesScroll(4,4,4,4,4)));
        assertEquals(50, Yatzy.yatzy(new DicesScroll(6,6,6,6,6)));
    }

    @Test public void testYatzyScores0() {
        assertEquals(0, Yatzy.yatzy(new DicesScroll(6,6,6,6,3)));
    }

    @Test public void testOnes() {
        assertEquals(1, Yatzy.ones(new DicesScroll(1,2,3,4,5)));
        assertEquals(2, Yatzy.ones(new DicesScroll(1,2,1,4,5)));
        assertEquals(0, Yatzy.ones(new DicesScroll(6,2,2,4,5)));
        assertEquals(4, Yatzy.ones(new DicesScroll(1,2,1,1,1)));
    }

    @Test
    public void testTwos() {
        assertEquals(4, Yatzy.twos(new DicesScroll(1,2,3,2,6)));
        assertEquals(10, Yatzy.twos(new DicesScroll(2,2,2,2,2)));
    }

    @Test
    public void testThrees() {
        assertEquals(6, Yatzy.threes(new DicesScroll(1,2,3,2,3)));
        assertEquals(12, Yatzy.threes(new DicesScroll(2,3,3,3,3)));
    }

    @Test
    public void testFours()
    {
        assertEquals(12, Yatzy.fours(new DicesScroll(4,4,4,5,5)));
        assertEquals(8, Yatzy.fours(new DicesScroll(4,4,5,5,5)));
        assertEquals(4, Yatzy.fours(new DicesScroll(4,5,5,5,5)));
    }

    @Test
    public void fives() {
        assertEquals(10, Yatzy.fives(new DicesScroll(4,4,4,5,5)));
        assertEquals(15, Yatzy.fives(new DicesScroll(4,4,5,5,5)));
        assertEquals(20, Yatzy.fives(new DicesScroll(4,5,5,5,5)));
    }

    @Test
    public void sixes_test() {
        assertEquals(0, Yatzy.sixes(new DicesScroll(4,4,4,5,5)));
        assertEquals(6, Yatzy.sixes(new DicesScroll(4,4,6,5,5)));
        assertEquals(18, Yatzy.sixes(new DicesScroll(6,5,6,6,5)));
    }

    @Test
    public void testOnePair() {
        assertEquals(6, Yatzy.onePair(new DicesScroll(3,4,3,5,6)));
        assertEquals(10, Yatzy.onePair(new DicesScroll(5,3,3,3,5)));
        assertEquals(12, Yatzy.onePair(new DicesScroll(5,3,6,6,5)));
    }

    @Test
    public void testTwoPair() {
        assertEquals(16, Yatzy.twoPair(new DicesScroll(3,3,5,4,5)));
        assertEquals(16, Yatzy.twoPair(new DicesScroll(3,3,5,5,5)));
    }

    @Test
    public void testThreeOfAKind()
    {
        assertEquals(9, Yatzy.threeOfAKind(new DicesScroll(3,3,3,4,5)));
        assertEquals(15, Yatzy.threeOfAKind(new DicesScroll(5,3,5,4,5)));
        assertEquals(9, Yatzy.threeOfAKind(new DicesScroll(3,3,3,3,5)));
        assertEquals(9, Yatzy.threeOfAKind(new DicesScroll(3,3,3,3,3)));
    }

    @Test
    public void testFourOfAKind() {
        assertEquals(12, Yatzy.fourOfAKind(new DicesScroll(3,3,3,3,5)));
        assertEquals(20, Yatzy.fourOfAKind(new DicesScroll(5,5,5,4,5)));

    }

    @Test
    public void smallStraight() {
        assertEquals(15, Yatzy.smallStraight(new DicesScroll(1,2,3,4,5)));
        assertEquals(15, Yatzy.smallStraight(new DicesScroll(2,3,4,5,1)));
        assertEquals(0, Yatzy.smallStraight(new DicesScroll(1,2,2,4,5)));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy.largeStraight(new DicesScroll(6,2,3,4,5)));
        assertEquals(20, Yatzy.largeStraight(new DicesScroll(2,3,4,5,6)));
        assertEquals(0, Yatzy.largeStraight(new DicesScroll(1,2,2,4,5)));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, Yatzy.fullHouse(new DicesScroll(6,2,2,2,6)));
        assertEquals(0, Yatzy.fullHouse(new DicesScroll(2,3,4,5,6)));
    }
}
