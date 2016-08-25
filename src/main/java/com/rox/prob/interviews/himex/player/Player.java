package com.rox.prob.interviews.himex.player;

import com.rox.prob.interviews.himex.cards.BlackjackHand;
import com.rox.prob.interviews.himex.cards.Card;

import java.util.Scanner;

/**
 * TODO Make getUserInput() method injectable for unit testing
 */
public class Player implements BlackjackPlayer {
    private BlackjackHand hand;
    private int chips;
    private String name;

    public Player(String name, int chips){
        this.name = name;
        this.chips = chips;
        hand = new BlackjackHand();
    }

    public Player(int chips){
        this.name = getUserInput("Please enter player name: ").trim();
        this.chips = chips;
        hand = new BlackjackHand();
    }

    public String getName(){
        return name;
    }

    /**
     * Drop the current hand and return what was held
     */
    public BlackjackHand burnHand() {
        BlackjackHand oldHand = hand;
        hand = new BlackjackHand();
        return oldHand;
    }

    private int getInt(String message){
        String input = getUserInput(message);
        Scanner s = new Scanner(input);
        int inputValue = s.nextInt();
        return inputValue;
    }

    private String getUserInput(String message){
        System.out.print(message);
        String input = System.console().readLine();
        return input;
    }

    @Override
    public int makeWager(int suggestedWager){
        int actualWager = 0;

        if (suggestedWager > chips){
            actualWager = chips;
            chips = 0;
        }else{
            actualWager = suggestedWager;
            chips -= suggestedWager;
        }

        return actualWager;
    }

    @Override
    public int getChips(){
        return chips;
    }

    @Override
    public BlackjackHand getHand(){
        return hand;
    }

    @Override
    public void reset() {
        burnHand();
    }

    @Override
    public void dealCard(Card card){
        hand.addCard(card);
    }

    @Override
    public int getBet() {
        return getInt("How much would you like to bet " + getName() + "? ");
    }

    @Override
    public PlayerStatus getAction() {
        String response = getUserInput("What would you like to do? (S)tick or (H)it? ");

        switch (response.trim().toLowerCase()) {
            case "s":
                return PlayerStatus.STICK;
            case "h":
                return PlayerStatus.HIT;
        }

        return null;
    }

    @Override
    public void giveWinnings(int winnings) {
        chips+=winnings;
    }
}
