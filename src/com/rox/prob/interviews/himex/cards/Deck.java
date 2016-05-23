package com.rox.prob.interviews.himex.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Deck of Cards
 */
public class Deck {
    private List<Card> freshDeck;
    private List<Card> spentDeck;

    private Random random = new Random();

    public Deck(){
        Card.VALUE[] values = Card.VALUE.values();
        Card.SUIT[] suits = Card.SUIT.values();

        freshDeck = new ArrayList<Card>();
        spentDeck = new ArrayList<Card>();

        for (Card.SUIT suit : suits){
            for (Card.VALUE value : values){
                freshDeck.add(new Card(suit, value));
            }
        }
    }

    public int getSize(){
        return getSpentCardCount() + getRemainingCardCount();
    }

    public int getSpentCardCount(){
        return spentDeck.size();
    }

    public int getRemainingCardCount(){
        return freshDeck.size();
    }

    public Card deal() {
        int cardIndex = freshDeck.size()-1;
        Card dealtCard = freshDeck.remove(cardIndex);
        spentDeck.add(dealtCard);
        return dealtCard;
    }

    public Card[] dump(){
        Card[] dumpedDeck = new Card[freshDeck.size()];
        int i=0;
        for (Card card : freshDeck){
            dumpedDeck[i++] = card;
        }

        return dumpedDeck;
    }

   /**
    * Rather than use a digital randomisation,
    * this is an attempt to simulate real shuffling.
    */
    public void shuffle() {
        int cuts = random.nextInt(25 - 10) + 10;

        for (int cut=0; cut < cuts; cut++){
            cutAndReturn(0, 25);
            centreCutAndReturnShuffle();
        }
    }

    public void fullShuffle(){
        freshDeck.addAll(spentDeck);
        spentDeck.clear();
        shuffle();
    }

    /**
     * Very simple shuffle.
     * Cut random number of cards from the center of the
     * deck and add to the end.
     */
    private void centreCutAndReturnShuffle(){
        int cutPoint = random.nextInt(freshDeck.size() + 1);
        int cutEndPoint = random.nextInt(freshDeck.size() - cutPoint + 1) + cutPoint;

        cutAndReturn(cutPoint, cutEndPoint);
    }

    /**
     * Cut a number of cards from the deck and add to the end
     */
    public void cutAndReturn(int start, int end){
        List<Card> cardsInHand = new ArrayList<Card>();

        List<Card> view = freshDeck.subList(start, end);
        cardsInHand.addAll(view);
        view.clear();

        freshDeck.addAll(cardsInHand);
    }
}
