package com.rox.prob.interviews.himex.cards;

/**
 * QA single playing card with a suit and a value
 */
public class Card {
    public enum SUIT {  HEARTS("h"),
                        DIAMONDS("d"),
                        CLUBS("c"),
                        SPADES("s");
        private String myID;

        String getMyID(){
            return myID;
        }

        SUIT(String id){
            myID = id;
        }
    }

    public enum VALUE { ACE("A"),
                        TWO("2"),
                        THREE("3"),
                        FOUR("4"),
                        FIVE("5"),
                        SIX("6"),
                        SEVEN("7"),
                        EIGHT("8"),
                        NINE("9"),
                        TEN("10"),
                        JACK("J"),
                        QUEEN("Q"),
                        KING("K"),;

        private String myID;

        String getMyID(){
            return myID;
        }

        VALUE(String id){
            myID = id;
        }
    }

    private final SUIT mySuit;
    private final VALUE myFaceValue;

    public Card(SUIT suit, VALUE faceValue){
        mySuit = suit;
        myFaceValue = faceValue;
    }

    public SUIT getSuit(){
        return mySuit;
    }

    public VALUE getFaceValue(){
        return myFaceValue;
    }

    public String toString(){

        return myFaceValue.getMyID() + mySuit.getMyID();
    }

    public int compareTo(Card card){
        if (myFaceValue == card.getFaceValue() && mySuit == card.getSuit()){
            return 0;
        }
        else
        {
            return -1;
        }
    }
}
