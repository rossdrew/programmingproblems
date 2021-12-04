package com.rox.adventofcode.y2021

import com.rox.adventofcode.puzzleInputFromFile
import java.lang.RuntimeException

private val inputSample = """
7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1

22 13 17 11  0
 8  2 23  4 24
21  9 14 16  7
 6 10  3 18  5
 1 12 20 15 19

 3 15  0  2 22
 9 18 13 17  5
19  8  7 25 23
20 11 10 24  4
14 21 16 12  6

14 21 17 24  4
10 16 15  9 19
18  8 23 26 20
22 11 13  6  5
 2  0 12  3  7
""".trimIndent()

fun main() {
    //println("Sample Input A: ${solutionA(inputSample)}")
    //println("Sample Input B: ${solutionB(inputSample)}")
    //println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2021/Day4.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2021/Day4.input"))}")
}

/**
 * --- Day 4: Giant Squid ---
 * You're already almost 1.5km (almost a mile) below the surface of the ocean, already so deep that you can't see
 * any sunlight. What you can see, however, is a giant squid that has attached itself to the outside of your submarine.
 *
 * Maybe it wants to play bingo?
 *
 * Bingo is played on a set of boards each consisting of a 5x5 grid of numbers. Numbers are chosen at random, and the
 * chosen number is marked on all boards on which it appears. (Numbers may not appear on all boards.) If all numbers
 * in any rows or any column of a board are marked, that board wins. (Diagonals don't count.)
 *
 * The submarine has a bingo subsystem to help passengers (currently, you and the giant squid) pass the time. It
 * automatically generates a random order in which to draw numbers and a random set of boards (your puzzle input).
 * For example:
 *
 * 7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1
 *
 * 22 13 17 11  0
 * 8  2 23  4 24
 * 21  9 14 16  7
 * 6 10  3 18  5
 * 1 12 20 15 19
 *
 * 3 15  0  2 22
 * 9 18 13 17  5
 * 19  8  7 25 23
 * 20 11 10 24  4
 * 14 21 16 12  6
 *
 * 14 21 17 24  4
 * 10 16 15  9 19
 * 18  8 23 26 20
 * 22 11 13  6  5
 * 2  0 12  3  7
 * After the first five numbers are drawn (7, 4, 9, 5, and 11), there are no winners, but the boards are marked as
 * follows (shown here adjacent to each other to save space):
 *
 * 22 13 17 11  0         3 15  0  2 22        14 21 17 24  4
 * 8  2 23  4 24         9 18 13 17  5        10 16 15  9 19
 * 21  9 14 16  7        19  8  7 25 23        18  8 23 26 20
 * 6 10  3 18  5        20 11 10 24  4        22 11 13  6  5
 * 1 12 20 15 19        14 21 16 12  6         2  0 12  3  7
 * After the next six numbers are drawn (17, 23, 2, 0, 14, and 21), there are still no winners:
 *
 * 22 13 17 11  0         3 15  0  2 22        14 21 17 24  4
 * 8  2 23  4 24         9 18 13 17  5        10 16 15  9 19
 * 21  9 14 16  7        19  8  7 25 23        18  8 23 26 20
 * 6 10  3 18  5        20 11 10 24  4        22 11 13  6  5
 * 1 12 20 15 19        14 21 16 12  6         2  0 12  3  7
 * Finally, 24 is drawn:
 *
 * 22 13 17 11  0         3 15  0  2 22        14 21 17 24  4
 * 8  2 23  4 24         9 18 13 17  5        10 16 15  9 19
 * 21  9 14 16  7        19  8  7 25 23        18  8 23 26 20
 * 6 10  3 18  5        20 11 10 24  4        22 11 13  6  5
 * 1 12 20 15 19        14 21 16 12  6         2  0 12  3  7
 * At this point, the third board wins because it has at least one complete rows or column of marked numbers (in this
 * case, the entire top rows is marked: 14 21 17 24 4).
 *
 * The score of the winning board can now be calculated. Start by finding the sum of all unmarked numbers on that
 * board; in this case, the sum is 188. Then, multiply that sum by the number that was just called when the board won,
 * 24, to get the final score, 188 * 24 = 4512.
 *
 * To guarantee victory against the giant squid, figure out which board will win first. What will your final score be
 * if you choose that board?
 *
 * Answer: 25410
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')
    var playerIndex = 1

    //Parse out draws
    val drawSequence = rows[0]

    val draws = mutableListOf<Int>()
    for (draw in drawSequence.split(",")) {
        if (draw.isBlank()) break
        val drawnNumber = "$draw".toInt()
        draws.add(drawnNumber)
    }

    //Parse out players
    val players = mutableListOf<BingoCard>()
    var player = BingoCard(playerIndex++)
    for (rowIndex in 2 until rows.size){
        if (rows[rowIndex].trim().isEmpty()){
            players.add(player)
            player = BingoCard(playerIndex++)
        }else {
            val entries = rows[rowIndex].trim().split("\\s+".toRegex()).map { entry -> entry.toInt() }.toIntArray()
            player.add(entries)
        }
    }
    players.add(player)

    //for each number, do any players have a complete rows or column
    for (draw in draws){
        for (player in players){
            if (player.mark(draw)){
                //When a winner is found, what is the sum of the last drawn number and all remaining numbers on the winners board )
                return player.count() * draw
            }
        }
    }

    return input
}

data class BingoCard(val cardNumber: Int){
    val rows = mutableListOf<IntArray>()

    fun add(row : IntArray){
        this.rows.add(row)
    }

    fun mark(draw : Int) : Boolean {
        //remove number and return true if any rows or column is now empty
        for (row in rows){
            for (col in row.indices){
                if (row[col] == draw){
                    row[col] = -1
                    //Rows
                    if (row.none { c -> c != -1 }){
                        return true
                    }
                }
            }
        }

        //Column match
        col@ for (col in rows[0].indices){
            row@ for (row in rows){
                if (row[col] != -1){
                    continue@col
                }
            }
            return true
        }

        return false
    }

    fun count(): Int {
        //return the sum of all remaining numbers
        return this.rows.map { row -> row.filter { entry -> entry != -1 }.sum() }.sum()
    }
}

/**
 * --- Part Two ---
 *
 * On the other hand, it might be wise to try a different strategy: let the giant squid win.
 *
 * You aren't sure how many bingo boards a giant squid could play at once, so rather than waste time counting its
 * arms, the safe thing to do is to figure out which board will win last and choose that one. That way, no matter
 * which boards it picks, it will win for sure.
 *
 * In the above example, the second board is the last to win, which happens after 13 is eventually called and its
 * middle column is completely marked. If you were to keep playing until this point, the second board would have a
 * sum of unmarked numbers equal to 148 for a final score of 148 * 13 = 1924.
 *
 * Figure out which board will win last. Once it wins, what would its final score be?
 *
 * Answer: 20960 (WRONG, too high)
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')
    var playerIndex = 1

    //Parse out draws
    val drawSequence = rows[0]

    val draws = mutableListOf<Int>()
    for (draw in drawSequence.split(",")) {
        if (draw.isBlank()) break
        val drawnNumber = "$draw".toInt()
        draws.add(drawnNumber)
    }

    //Parse out players
    val players = mutableListOf<BingoCard>()
    var player = BingoCard(playerIndex++)
    for (rowIndex in 2 until rows.size){
        if (rows[rowIndex].trim().isEmpty()){
            players.add(player)
            player = BingoCard(playerIndex++)
        }else {
            val entries = rows[rowIndex].trim().split("\\s+".toRegex()).map { entry -> entry.toInt() }.toIntArray()
            player.add(entries)
        }
    }
    players.add(player)

    //for each number, do any players have a complete rows or column
    var eliminatedPlayers = mutableSetOf<BingoCard>()

    for (draw in draws){
        for (currentPlayer in players){
            if (!(eliminatedPlayers.contains(currentPlayer)) && currentPlayer.mark(draw)){
                //When a winner is found, what is the sum of the last drawn number and all remaining numbers on the winners board )
                if (players.size - eliminatedPlayers.size == 1) {
                    return currentPlayer.count() * draw
                }else{
                    eliminatedPlayers.add(currentPlayer)
                }
            }
        }

    }

    throw RuntimeException("Unexpected fallthrough, no completion condition exists")
}

