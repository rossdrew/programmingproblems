package com.rox.prob.interviews.himex.player;

import com.rox.prob.interviews.himex.cards.BlackjackHand;
import com.rox.prob.interviews.himex.cards.Card;

public class PokerDealer implements PokerPlayer {
    private BlackjackHand hand;

    public PokerDealer(){
        reset();
    }

    @Override
    public void reset() {
        hand = new BlackjackHand();
    }

    @Override
    public void dealCard(Card card) {
        hand.addCard(card);
    }

    @Override
    public int getBet() {
        //Dealer doesn't have chips
        return 0;
    }

    @Override
    public void giveWinnings(int winnings) {
        //Dealer doesn't have chips
    }

    @Override
    public int getChips() {
        //Dealer doesn't have chips
        return 0;
    }

    @Override
    public int makeWager(int suggestedWager) {
        //Dealer doesn't have chips
        return 0;
    }

    @Override
    public PlayerStatus getAction() {
        if (hand.getValue() < 17)
            return PlayerStatus.HIT;
        else
            return PlayerStatus.STICK;
    }

    @Override
    public BlackjackHand getHand() {
        return hand;
    }

    @Override
    public String getName() {
        return "Dealer";
    }
}
