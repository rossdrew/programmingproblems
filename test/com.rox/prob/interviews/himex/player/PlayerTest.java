package com.rox.prob.interviews.himex.player;


import com.rox.prob.interviews.himex.cards.BlackjackHand;
import com.rox.prob.interviews.himex.cards.Deck;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    Deck deck;
    Player player;

    @Before
    public void setup(){
        deck = new Deck();
        player = new Player("Ross", 100);
    }

    @Test
    public void testWager(){
        int wager = player.makeWager(1);

        assertEquals(1, wager);
        assertEquals(99, player.getChips());
    }

    @Test
    public void testAllInWager(){
        int wager = player.makeWager(100);

        assertEquals(100, wager);
        assertEquals(0, player.getChips());
    }

    @Test
    public void testOverWager(){
        int wager = player.makeWager(101);

        assertEquals(100, wager);
        assertEquals(0, player.getChips());
    }

    @Test
    public void testDeal(){
        player.dealCard(deck.deal());

        assertEquals(1, player.getHand().size());
    }

    @Test
    public void testFreshDeal(){
        player.dealCard(deck.deal());
        player.dealCard(deck.deal());
        BlackjackHand hand = player.getHand();
        player.reset();

        player.dealCard(deck.deal());

        assertEquals(1, player.getHand().size());
        assertEquals(2, hand.size());
    }
}
