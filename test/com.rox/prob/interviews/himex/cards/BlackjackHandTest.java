package com.rox.prob.interviews.himex.cards;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BlackjackHandTest {
    @Test
    public void testTenBlackJack(){
        Card[] cards = new Card[2];
        cards[0] = new Card(Card.SUIT.CLUBS, Card.VALUE.ACE);
        cards[1] = new Card(Card.SUIT.CLUBS, Card.VALUE.TEN);
        BlackjackHand hand = new BlackjackHand(cards);

        assertEquals(21, hand.getValue());
        assertTrue(hand.isBlackjack());
        assertFalse(hand.isBust());
    }

    @Test
    public void testJackBlackJack(){
        Card[] cards = new Card[2];
        cards[0] = new Card(Card.SUIT.CLUBS, Card.VALUE.ACE);
        cards[1] = new Card(Card.SUIT.CLUBS, Card.VALUE.JACK);
        BlackjackHand hand = new BlackjackHand(cards);

        assertEquals(21, hand.getValue());
        assertTrue(hand.isBlackjack());
        assertFalse(hand.isBust());
    }

    @Test
    public void testKingBlackJack(){
        Card[] cards = new Card[2];
        cards[0] = new Card(Card.SUIT.CLUBS, Card.VALUE.ACE);
        cards[1] = new Card(Card.SUIT.CLUBS, Card.VALUE.KING);
        BlackjackHand hand = new BlackjackHand(cards);

        assertEquals(21, hand.getValue());
        assertTrue(hand.isBlackjack());
        assertFalse(hand.isBust());
    }

    @Test
    public void testThreeCard21(){
        Card[] cards = new Card[3];
        cards[0] = new Card(Card.SUIT.CLUBS, Card.VALUE.EIGHT);
        cards[1] = new Card(Card.SUIT.SPADES, Card.VALUE.TEN);
        cards[2] = new Card(Card.SUIT.HEARTS, Card.VALUE.THREE);
        BlackjackHand hand = new BlackjackHand(cards);

        assertEquals(21, hand.getValue());
        assertFalse(hand.isBlackjack());
        assertFalse(hand.isBust());
    }

    @Test
    public void testFourCard21(){
        Card[] cards = new Card[4];
        cards[0] = new Card(Card.SUIT.CLUBS, Card.VALUE.EIGHT);
        cards[1] = new Card(Card.SUIT.SPADES, Card.VALUE.EIGHT);
        cards[2] = new Card(Card.SUIT.SPADES, Card.VALUE.TWO);
        cards[3] = new Card(Card.SUIT.HEARTS, Card.VALUE.THREE);
        BlackjackHand hand = new BlackjackHand(cards);

        assertEquals(21, hand.getValue());
        assertFalse(hand.isBlackjack());
        assertFalse(hand.isBust());
    }

    @Test
    public void testAcePair(){
        Card[] cards = new Card[2];
        cards[0] = new Card(Card.SUIT.CLUBS, Card.VALUE.ACE);
        cards[1] = new Card(Card.SUIT.SPADES, Card.VALUE.ACE);
        BlackjackHand hand = new BlackjackHand(cards);

        assertEquals(12, hand.getValue());
        assertFalse(hand.isBlackjack());
        assertFalse(hand.isBust());
    }

    @Test
    public void testAceWithNonBlackjack(){
        Card[] cards = new Card[2];
        cards[0] = new Card(Card.SUIT.CLUBS, Card.VALUE.ACE);
        cards[1] = new Card(Card.SUIT.SPADES, Card.VALUE.NINE);
        BlackjackHand hand = new BlackjackHand(cards);

        assertEquals(20, hand.getValue());
        assertFalse(hand.isBlackjack());
        assertFalse(hand.isBust());
    }

    @Test
    public void testAceAsOne(){
        Card[] cards = new Card[3];
        cards[0] = new Card(Card.SUIT.CLUBS, Card.VALUE.ACE);
        cards[1] = new Card(Card.SUIT.SPADES, Card.VALUE.EIGHT);
        cards[2] = new Card(Card.SUIT.SPADES, Card.VALUE.THREE);
        BlackjackHand hand = new BlackjackHand(cards);

        assertEquals(12, hand.getValue());
        assertFalse(hand.isBlackjack());
        assertFalse(hand.isBust());
    }

    @Test
    public void testBust(){
        Card[] cards = new Card[4];
        cards[0] = new Card(Card.SUIT.CLUBS, Card.VALUE.THREE);
        cards[1] = new Card(Card.SUIT.SPADES, Card.VALUE.EIGHT);
        cards[2] = new Card(Card.SUIT.HEARTS, Card.VALUE.SEVEN);
        cards[3] = new Card(Card.SUIT.HEARTS, Card.VALUE.FOUR);
        BlackjackHand hand = new BlackjackHand(cards);

        assertEquals(22, hand.getValue());
        assertFalse(hand.isBlackjack());
        assertTrue(hand.isBust());
    }

    @Test
    public void testCompareEqualHands(){
        Card[] cards;
        cards = new Card[4];
        cards[0] = new Card(Card.SUIT.CLUBS, Card.VALUE.ACE);
        cards[1] = new Card(Card.SUIT.SPADES, Card.VALUE.TWO);
        cards[2] = new Card(Card.SUIT.HEARTS, Card.VALUE.THREE);
        cards[3] = new Card(Card.SUIT.HEARTS, Card.VALUE.FOUR);
        BlackjackHand hand1 = new BlackjackHand(cards);

        cards = new Card[4];
        cards[0] = new Card(Card.SUIT.CLUBS, Card.VALUE.ACE);
        cards[1] = new Card(Card.SUIT.SPADES, Card.VALUE.TWO);
        cards[2] = new Card(Card.SUIT.HEARTS, Card.VALUE.THREE);
        cards[3] = new Card(Card.SUIT.HEARTS, Card.VALUE.FOUR);
        BlackjackHand hand2 = new BlackjackHand(cards);

        assertEquals(0, hand1.compareTo(hand2));
    }


    @Test
    public void testCompareLessThan(){
        Card[] cards;
        cards = new Card[4];
        cards[0] = new Card(Card.SUIT.CLUBS, Card.VALUE.ACE);
        cards[1] = new Card(Card.SUIT.SPADES, Card.VALUE.TWO);
        cards[2] = new Card(Card.SUIT.HEARTS, Card.VALUE.THREE);
        cards[3] = new Card(Card.SUIT.HEARTS, Card.VALUE.TWO);
        BlackjackHand hand1 = new BlackjackHand(cards);

        cards = new Card[4];
        cards[0] = new Card(Card.SUIT.CLUBS, Card.VALUE.ACE);
        cards[1] = new Card(Card.SUIT.SPADES, Card.VALUE.TWO);
        cards[2] = new Card(Card.SUIT.HEARTS, Card.VALUE.THREE);
        cards[3] = new Card(Card.SUIT.HEARTS, Card.VALUE.FOUR);
        BlackjackHand hand2 = new BlackjackHand(cards);

        assertEquals(-2, hand1.compareTo(hand2));
    }

    @Test
    public void testCompareGreaterThan(){
        Card[] cards;
        cards = new Card[4];
        cards[0] = new Card(Card.SUIT.CLUBS, Card.VALUE.ACE);
        cards[1] = new Card(Card.SUIT.SPADES, Card.VALUE.TWO);
        cards[2] = new Card(Card.SUIT.HEARTS, Card.VALUE.THREE);
        cards[3] = new Card(Card.SUIT.HEARTS, Card.VALUE.EIGHT);
        BlackjackHand hand1 = new BlackjackHand(cards);

        cards = new Card[4];
        cards[0] = new Card(Card.SUIT.CLUBS, Card.VALUE.TWO);
        cards[1] = new Card(Card.SUIT.SPADES, Card.VALUE.TWO);
        cards[2] = new Card(Card.SUIT.HEARTS, Card.VALUE.TWO);
        cards[3] = new Card(Card.SUIT.HEARTS, Card.VALUE.FOUR);
        BlackjackHand hand2 = new BlackjackHand(cards);

        assertEquals(4, hand1.compareTo(hand2));
    }

    @Test
    public void testCompareBust(){
        Card[] cards;
        cards = new Card[3];
        cards[0] = new Card(Card.SUIT.CLUBS, Card.VALUE.KING);
        cards[1] = new Card(Card.SUIT.SPADES, Card.VALUE.QUEEN);
        cards[2] = new Card(Card.SUIT.HEARTS, Card.VALUE.JACK);
        BlackjackHand hand1 = new BlackjackHand(cards);

        cards = new Card[4];
        cards[0] = new Card(Card.SUIT.CLUBS, Card.VALUE.TWO);
        cards[1] = new Card(Card.SUIT.SPADES, Card.VALUE.TWO);
        cards[2] = new Card(Card.SUIT.HEARTS, Card.VALUE.TWO);
        cards[3] = new Card(Card.SUIT.HEARTS, Card.VALUE.FOUR);
        BlackjackHand hand2 = new BlackjackHand(cards);

        assertEquals(-1, hand1.compareTo(hand2));
    }
}
