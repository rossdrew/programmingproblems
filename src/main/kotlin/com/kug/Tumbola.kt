package com.kug

import kotlin.random.Random.Default.nextInt

/**
 * A simple Kotlin snippet to take the number of Kotliners present at the Edinburgh Kotlin User Group
 * and select a number that corresponds to their name on the registration sheet to decide who wins a prize.
 */

/**
 * Number of people playing
 *
 * Q: Anyone know why val requires to be declared
 *    const yet 'lateinit val T = 9' indicates
 *    that val is immutable?
 */
const val PLAYERS = 10

/**
 * Original: Pick a winning number from 1 to players
 */
fun pickWinningNumber(players: Int = 1) : Int {
    return nextInt(1, players)
}

/**
 * KUG#1 (02 July 2019):
 *
 * After discussion on refactoring the code above, it became this
 */
var picker  = { i: Int -> nextInt(1, i) }

fun main(args: Array<String>) {
    println("And the winning number is " + pickWinningNumber(PLAYERS))
}