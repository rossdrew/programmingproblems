package com.rox.prob.interviews.himex.cards;

import java.util.ArrayList;
import java.util.List;

public class BlackjackHand {
    private int value = 0;
    private boolean blackjack = false;
    private List<Card> hand;

    public BlackjackHand(){
        this.hand = new ArrayList<>();
    }

    public BlackjackHand(Card[] hand){
        blackjack = false;

        this.hand = new ArrayList<>();
        addCards(hand);
    }

    private void addCards(Card[] hand) {
        for (Card c : hand){
            addCard(c);
        }
    }

    public void addCard(Card card){
        this.hand.add(card);
        value = evaluateHand();
    }

    private int evaluateHand() {
        int handValue = 0;
        boolean containsAce = false;

        if (testForBlackjack()) {
            handValue = 21;
            blackjack = true;
            return handValue;
        }

        return evaluateNonBlackjackHand(containsAce);
    }

    private int evaluateNonBlackjackHand(boolean containsAce) {
        int handValue = 0;

        for (Card card : hand){
            if (card.getFaceValue() == Card.VALUE.ACE)
                containsAce = true;

            int faceValue = card.getFaceValue().ordinal()+1;
            if (faceValue > 10)
                faceValue = 10;
            handValue += faceValue;
        }

        //Is Ace worth 1 or 11?
        if (containsAce && handValue < 12){
            handValue += 10;
        }

        return handValue;
    }

    private boolean testForBlackjack() {
        if (hand.size() != 2)
            return false;

        boolean ten = false;
        boolean ace = false;

        for (int i=0; i<2; i++) {
            if (hand.get(i).getFaceValue() == Card.VALUE.ACE) {
                ace = true;
            } else if (hand.get(i).getFaceValue().ordinal() >= 9) {
                ten = true;
            }
        }

        return (ten && ace);
    }

    public int getValue(){
        return value;
    }

    public boolean isBlackjack(){
        return blackjack;
    }

    public boolean isBust(){
        return value > 21;
    }

    public int size(){
        return hand.size();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (Card c : hand){
            sb.append(c.toString() + "  ");
        }

        return sb.toString();
    }

    public int compareTo(BlackjackHand hand){
        if (isBlackjack() && hand.isBlackjack() || isBust() && hand.isBust()){
            return 0;
        }

        if (isBlackjack() || hand.isBlackjack()){
            return (isBlackjack() ? 1 : -1);
        }

        if (isBust() || hand.isBust()){
            return (isBust() ? -1 : 1);
        }

        return getValue() - hand.getValue();
    }
}
