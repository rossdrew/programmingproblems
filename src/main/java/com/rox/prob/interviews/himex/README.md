# Himex Blackjack

This is a console based __Black Jack__ implementation with the following description.

 The result should be a Java command line app that allows the user
to play a game of Blackjack. The computer will represent the
dealer. To reduce the complexity we have simplified the rules:

  - The computer will act as dealer
  - The dealer will deal from four decks
  - After 75% of the deck has been consumed, the deck is reshuffled
  - The dealer will stand on 17, hit on 16
  - We will ignore, insurance, double down, split, and surrender
  - The player will start with 100 chips, and their score will be maintained throughout games
  - After each play the player will be asked if they want to continue and their bet
  - The application will exit when the player has depleted all their chips or chooses not to continue.
  - The player's final chip count is displayed on exit

# Running

  It can be run in the Maven test phase with the command ```mvn test``` which also runs the unit tests.

# The Game
 Cards are shown as codes, e.g.:-
  - As (<i>Ace of Spades</i>)
  - Kc (<i>King of Clubs</i>
  - 10h (<i>Ten of Hearts</i>)
  
 This is just to make the interface cleaner.  There are some ASCII suit characters but they don't work properly on some consoles.

# Thoughts

 I would like to have made this in a more TDD fashion but some domain knowledge is really required to do TDD properly and this is my first
 black jack game.  There are some unit tests, just not as many as I'd like.
 I learned as I went and realised later that the user input could have  been done in a nicer way to allow better unit testing and I moved the design towards it.
 I didn't have the kind of time I'd have liked to on this either and  I rushed a few bits, namely the game loop which I did a little refactoring on.

 # Future
 I'll continue to work on this later.  Redesign for better unit testing (with a focus on user input) and run some Pitesting on it.
