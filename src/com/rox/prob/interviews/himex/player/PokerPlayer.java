package com.rox.prob.interviews.himex.player;

import com.rox.prob.interviews.himex.cards.BlackjackHand;
import com.rox.prob.interviews.himex.cards.Card;

public interface PokerPlayer {
    enum PlayerStatus {HIT, STICK};

    void reset();
    void dealCard(Card card);
    int getBet();
    PlayerStatus getAction();
    BlackjackHand getHand();
    String getName();
    void giveWinnings(int winnings);
    int getChips();
    int makeWager(int suggestedWager);
}
