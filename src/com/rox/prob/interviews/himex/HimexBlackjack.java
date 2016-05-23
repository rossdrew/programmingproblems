package com.rox.prob.interviews.himex;

import com.rox.prob.interviews.himex.cards.BlackjackHand;
import com.rox.prob.interviews.himex.cards.Deck;
import com.rox.prob.interviews.himex.player.Player;
import com.rox.prob.interviews.himex.player.PokerDealer;
import com.rox.prob.interviews.himex.player.PokerPlayer;

import java.util.Scanner;

/**
 * Technical Test
 *
 * We would like to gain an understanding of your technical abilities,
 * your design skills and your experience. To help us achieve this we
 * would like for you to complete this small project.
 *
 * The result should be a Java command line app that allows the user
 * to play a game of Blackjack. The computer will represent the
 * dealer. To reduce the complexity we have simplified the rules:
 *
 * - The computer will act as dealer
 * - The dealer will deal from four decks
 * - After 75% of the deck has been consumed, the deck is reshuffled
 * - The dealer will stand on 17, hit on 16
 * - We will ignore, insurance, double down, split, and surrender
 * - The player will start with 100 chips, and their score will be
 *   maintained throughout games
 * - After each play the player will be asked if they want to
 *   continue and their bet
 * - The application will exit when the player has depleted all
 *   their chips or chooses not to continue.
 * - The player’s final chip count is displayed on exit
 *
 * We are interested in how you develop an application so please make
 * this a repository, on GitHub or BitBucket, with frequent commits.
 * Furthermore, we’re looking for production ready code, so please
 * include tests, documentation, and whatever else you feel is
 * required etc.
 *
 * NOTES:
 *
 * - The deck being reshuffled doesn't mention spent cards. I'm assuming they get reintegrated.
 * - There's no description of why there are 4 decks.  I'm Assuming user picks a deck.
 *     - This assumption was wrong.  Decks should be combined, I'm not sure
 *       how this would deal with duplicate cards however.
 */
public class HimexBlackjack {
    public enum PlayerStatus {HIT, STICK};

    public static final int majorVersion = 1;
    public static final int minorVersion = 0;

    private Deck[] decks = new Deck[4];
    private PokerPlayer player;
    private int playingDeck = 1;
    private PokerPlayer dealer = new PokerDealer();

    public HimexBlackjack(){
        printHeader();
        setupGame();
        runGameLoop();

        System.out.println("Game Over - " + (player.getChips() > 0 ? "Walking away with " + player.getChips() + " chips" : "Out of Chips"));
    }

    private void runGameLoop() {
        boolean exitRequired = false;
        while(!exitRequired){
            playRound();

            if (player.getChips() == 0){
                exitRequired = true;
            }else{
                exitRequired = promptToContinue();
            }
        }
    }

    private void playRound() {
        int betValue = player.makeWager(player.getBet());
        System.out.println("Betting " + betValue + " chips...");

        playerCycle(player);
        playerCycle(dealer);

        compareHands(betValue);
        shuffleIfLowOnCards();
    }

    private void shuffleIfLowOnCards() {
        int spentCards = decks[playingDeck].getSpentCardCount();
        if (spentCards > (decks[playingDeck].getSize() * .75)){
            decks[playingDeck].fullShuffle();
        }
    }

    private void compareHands(int betValue) {
        BlackjackHand playersHand = player.getHand();
        BlackjackHand dealersHand = dealer.getHand();
        int result = playersHand.compareTo(dealersHand);

        int winnings = 0;
        if (result == 0){
            winnings = betValue;
            System.out.println("Draw! " + player.getName() + " receives " + winnings);
        }else if (result > 0){
            winnings = betValue*2;
            System.out.println(player.getName() + " Won! Receives " + winnings);
        }else{
            System.out.println(player.getName() + " Lost!");
        }
        player.giveWinnings(winnings);
    }

    private void playerCycle(PokerPlayer player){
        System.out.println("\nTurn = " + player.getName() + "...");
        player.reset();
        player.dealCard(decks[playingDeck].deal());
        player.dealCard(decks[playingDeck].deal());

        BlackjackHand hand = player.getHand();
        if (hand.isBlackjack()){
            System.out.println(player.getName() + " has Blackjack:-\n" + hand.toString());
            return;
        }else {
            boolean stuck = false;
            while (!hand.isBust() && !stuck) {
                System.out.println(player.getName() + " is at " + hand.getValue() + " with:-\n\t" + hand.toString());
                switch (player.getAction()) {
                    case STICK:
                        System.out.println(player.getName() + " sticking at " + hand.getValue());
                        return;
                    case HIT:
                        player.dealCard(decks[playingDeck].deal());
                        hand = player.getHand();
                }

            }
        }

        System.out.println(hand.toString() + " : bust at " + hand.getValue());
    }

    private boolean promptToContinue() {
        while(true) {
            String response = getCommandLineInput(player.getName() + " has " + player.getChips() + " chips. Would you like to continue (Y/N)? ");
            switch (response.trim().toLowerCase()) {
                case "n":
                case "no":
                    return true;
                case "y":
                case "yes":
                    return false;
                default:
                    System.out.println("Invalid input, please type Y(es) or N(o)");
            }
        }
    }

    public void setupGame() {
        for (int i=0; i<4; i++){
            decks[i] = new Deck();
            decks[i].shuffle();
        }

        player = new Player(100);
        System.out.println("Welcome " + player.getName() + ", you have 100 chips...");

        playingDeck = getIntFromCommandLine("Which deck would you like to play from [1-4]: ");
        if (playingDeck > 4){
            playingDeck = 4;
        }
        playingDeck--;
        System.out.println("Playing with deck " + (playingDeck+1));
    }

    private String getCommandLineInput(String message){
        System.out.print(message);
        String input = System.console().readLine();
        return input;
    }

    private int getIntFromCommandLine(String message){
        String input = getCommandLineInput(message);
        Scanner s = new Scanner(input);
        int inputValue = s.nextInt();
        return inputValue;
    }

    private void printHeader(){
        System.out.println("  ____  _            _           _            _    \n" +
                           " |  _ \\| |          | |         | |          | |   \n" +
                           " | |_) | | __ _  ___| | __      | | __ _  ___| | __\n" +
                           " |  _ <| |/ _` |/ __| |/ /  _   | |/ _` |/ __| |/ /\n" +
                           " | |_) | | (_| | (__|   <  | |__| | (_| | (__|   < \n" +
                           " |____/|_|\\__,_|\\___|_|\\_\\  \\____/ \\__,_|\\___|_|\\_\\\n" +
                           "                                                   ");
    }

    public static void main(String[] args){
        System.out.println("Starting HimexBlackjack v" + majorVersion + "." + minorVersion + " by Ross W. Drew");

        HimexBlackjack blackjack = new HimexBlackjack();
    }
}
