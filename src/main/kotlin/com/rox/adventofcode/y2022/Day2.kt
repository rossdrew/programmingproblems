package com.rox.adventofcode.y2022

import com.rox.adventofcode.puzzleInputFromFile
import com.rox.adventofcode.y2022.Hand.*
import com.rox.adventofcode.y2022.Outcome.*
import java.rmi.UnexpectedException

private val inputSample = """
A Y
B X
C Z
""".trimIndent()

fun main() {
    println("Sample Input A: ${solutionA(inputSample)}")
    println("Sample Input B: ${solutionB(inputSample)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2022/Day2.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2022/Day2.input"))}")
}

/**
 * --- Day 2: Rock Paper Scissors ---
 * The Elves begin to set up camp on the beach. To decide whose tent gets to be closest to the snack storage, a giant
 * Rock Paper Scissors tournament is already in progress.
 *
 * Rock Paper Scissors is a game between two players. Each game contains many rounds; in each round, the players each
 * simultaneously choose one of Rock, Paper, or Scissors using a hand shape. Then, a winner for that round is
 * selected: Rock defeats Scissors, Scissors defeats Paper, and Paper defeats Rock. If both players choose the same
 * shape, the round instead ends in a draw.
 *
 * Appreciative of your help yesterday, one Elf gives you an encrypted strategy guide (your puzzle input) that they say
 * will be sure to help you win. "The first column is what your opponent is going to play: A for Rock, B for Paper,
 * and C for Scissors. The second column--" Suddenly, the Elf is called away to help with someone's tent.
 *
 * The second column, you reason, must be what you should play in response: X for Rock, Y for Paper, and Z for Scissors.
 * Winning every time would be suspicious, so the responses must have been carefully chosen.
 *
 * The winner of the whole tournament is the player with the highest score. Your total score is the sum of your scores
 * for each round. The score for a single round is the score for the shape you selected (1 for Rock, 2 for Paper, and 3
 * for Scissors) plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won).
 *
 * Since you can't be sure if the Elf is trying to help you or trick you, you should calculate the score you would get
 * if you were to follow the strategy guide.
 *
 * For example, suppose you were given the following strategy guide:
 *
 * A Y
 * B X
 * C Z
 * This strategy guide predicts and recommends the following:
 *
 * In the first round, your opponent will choose Rock (A), and you should choose Paper (Y). This ends in a win for you
 * with a score of 8 (2 because you chose Paper + 6 because you won).
 * In the second round, your opponent will choose Paper (B), and you should choose Rock (X). This ends in a loss for you
 * with a score of 1 (1 + 0).
 * The third round is a draw with both players choosing Scissors, giving you a score of 3 + 3 = 6.
 * In this example, if you were to follow the strategy guide, you would get a total score of 15 (8 + 1 + 6).
 *
 * What would your total score be if everything goes exactly according to your strategy guide?
 *
 * Answer: 15632
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')

    val results = rows.map { row -> calculateResultA(row.split(" ").map { hand -> handFromChar(hand[0]) }) }

    return results.sum()
}

/**
 * --- Part Two ---
 * The Elf finishes helping with the tent and sneaks back over to you. "Anyway, the second column says how the round
 * needs to end: X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win.
 * Good luck!"
 *
 * The total score is still calculated in the same way, but now you need to figure out what shape to choose so the round
 * ends as indicated. The example above now goes like this:
 *
 * In the first round, your opponent will choose Rock (A), and you need the round to end in a draw (Y), so you also
 * choose Rock. This gives you a score of 1 + 3 = 4.
 * In the second round, your opponent will choose Paper (B), and you choose Rock so you lose (X) with a score of
 * 1 + 0 = 1.
 * In the third round, you will defeat your opponent's Scissors with Rock for a score of 1 + 6 = 7.
 * Now that you're correctly decrypting the ultra top secret strategy guide, you would get a total score of 12.
 *
 * Following the Elf's instructions for the second column, what would your total score be if everything goes exactly
 * according to your strategy guide?
 *
 * Answer: ???
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')

    val results = rows.map { row -> calculateResultB(row) }

    return results.sum()
}

fun calculateResultB(row: String): Int {
    val col = row.split(" ")
    val player1 = handFromChar(col[0][0])
    val intendedResult = outcomeFromChar(col[1][0])

    val player2 = when (intendedResult){
        DRAW -> player1
        LOSE -> {
            when (player1){
                ROCK -> SCISSORS
                PAPER -> ROCK
                SCISSORS -> PAPER
            }
        }
        WIN -> {
            when (player1){
                ROCK -> PAPER
                PAPER -> SCISSORS
                SCISSORS -> ROCK
            }
        }
    }

    return player2.rank + intendedResult.points
}

fun calculateResultA(hands: List<Hand>): Int {
    val player1 = hands[0]
    val player2 = hands[1]
    val result = when (player1){
        ROCK -> {
            when (player2) {
                ROCK -> DRAW
                PAPER -> WIN
                SCISSORS -> LOSE
            }
        }
        PAPER -> {
            when (player2) {
                ROCK -> LOSE
                PAPER -> DRAW
                SCISSORS -> WIN
            }
        }
        SCISSORS -> {
            when (player2) {
                ROCK -> WIN
                PAPER -> LOSE
                SCISSORS -> DRAW
            }
        }
    }

    return player2.rank + result.points
}

/** Technically wrong for B but it'll work if we rely on valid input */
fun handFromChar(c: Char): Hand {
    return when (c){
        'A','X' -> ROCK
        'B','Y' -> PAPER
        'C','Z' -> SCISSORS
        else -> throw UnexpectedException("$c is invalid, must be 'a','b' or 'c' or 'x','y' or 'z'")
    }
}

fun outcomeFromChar(c: Char): Outcome {
    return when (c) {
        'X' -> LOSE
        'Y' -> DRAW
        'Z' -> WIN
        else -> throw UnexpectedException("$c is invalid, must be 'x','y' or 'z'")
    }
}

enum class Hand(val rank: Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);
}

enum class Outcome(val points: Int, intent: Char) {
    LOSE(0, 'X'),
    DRAW(3, 'Y'),
    WIN(6, 'Z');
}
