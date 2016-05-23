package com.rox.prob.interviews.himex.cards;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class DeckTest {
    Deck deck;

    @Before
    public void setup(){
        deck = new Deck();
    }

    @Test
    public void testCreation(){
        assertEquals(52, deck.getSize());
        assertEquals(52, deck.getRemainingCardCount());
        assertEquals(0, deck.getSpentCardCount());
    }

    @Test
    public void testCardDeal(){
        deck.deal();

        assertEquals(52, deck.getSize());
        assertEquals(51, deck.getRemainingCardCount());
        assertEquals(1, deck.getSpentCardCount());
    }

    @Test
    public void testDealOut(){
        for (int i=0; i < 52; i++){
            deck.deal();
        }

        try{
            deck.deal();
            fail("Deck is empty, exception expected but not thrown");
        }catch(ArrayIndexOutOfBoundsException e){
          //Expected
        }

        assertEquals(52, deck.getSize());
        assertEquals(0, deck.getRemainingCardCount());
        assertEquals(52, deck.getSpentCardCount());
    }

    @Test
    public void testShuffle(){
        Card[] preShuffledDeck = deck.dump();
        deck.shuffle();
        Card[] postShuffledDeck = deck.dump();

        int diffCount = 0;
        for (int i=0; i<52; i++){
            if (preShuffledDeck[i].compareTo(postShuffledDeck[i])!=0){
                diffCount++;
            }
        }

        Assert.assertTrue("Cards weren't sufficiently shuffled", diffCount > 30);
    }

    @Test
    public void testFullShuffle(){
        deck.deal();
        deck.deal();
        deck.deal();
        deck.deal();

        assertEquals(52, deck.getSize());
        assertEquals(48, deck.getRemainingCardCount());
        assertEquals(4, deck.getSpentCardCount());
        deck.fullShuffle();
        assertEquals(52, deck.getSize());
        assertEquals(52, deck.getRemainingCardCount());
        assertEquals(0, deck.getSpentCardCount());
    }
}
