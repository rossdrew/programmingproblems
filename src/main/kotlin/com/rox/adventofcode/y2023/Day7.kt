package com.rox.adventofcode.y2023

import com.rox.adventofcode.puzzleInputFromFile
import java.rmi.UnexpectedException
import kotlin.math.min

private val inputSample = """
32T3K 765
T55J5 684
KK677 28
KTJJT 220
QQQJA 483
""".trimIndent()

fun main() {
    //println("Sample Input A: ${solutionA(inputSample)}")
    //println("Sample Input B: ${solutionB(inputSample)}")
    //println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2023/Day7.input"))}")
    println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2023/Day7.input"))}")
}

private fun rankToName(rank: Int) : String {
    return when (rank) {
        1 -> "Five of a Kind"
        2 -> "Four of a Kind"
        3 -> "Full House"
        4 -> "Three of a Kind"
        5 -> "Two Pair"
        6 -> "One Pair"
        7 -> "High Card"
        else -> "Unknown"
    }
}

data class Hand(val cards: String,
                val bid: Int,
                val cardWeightFunction: (Char) -> Int = ::cardWeight,
                val handWeightFunction: (List<Pair<Char, Int>>) -> Int = ::handWeight) : Comparable<Hand> {
    val rank by lazy { calculateMajorRank(cards) }

    private fun calculateMajorRank(hand: String): Int {
        val limitedCounts = hand
            .toCharArray()
            .distinct()
            .map { rank -> rank to (hand.filter { c -> c == rank }.length) }
            .sortedBy { e -> e.second }
            .reversed()

        return handWeightFunction(limitedCounts)
    }

    override fun compareTo(otherHand: Hand): Int {
        val rankDiff = (rank - otherHand.rank) * 10
        if (rankDiff != 0)
            return rankDiff
        val comparisonSize = min(cards.length, otherHand.cards.length)
        for (i in 0 until comparisonSize){
            val cardWeight = cardWeightFunction(cards[i])
            val otherCardWeight = cardWeightFunction( otherHand.cards[i])
            if (cardWeight == otherCardWeight) continue
            return otherCardWeight - cardWeight //XXX Not sure why this is the right way around here and not theother way?!
        }
        return 0 //equal
    }
}

private fun handWeight(limitedCounts: List<Pair<Char, Int>>): Int {
    return when {
        limitedCounts[0].second == 5 -> 1 //Five of a kind, where all five cards have the same label: AAAAA
        limitedCounts[0].second == 4 -> 2 //Four of a kind, where four cards have the same label and one card has a different label: AA8AA
        limitedCounts[0].second == 3 && limitedCounts[1].second == 2 -> 3 //Full house, where three cards have the same label, and the remaining two cards share a different label: 23332
        limitedCounts[0].second == 3 -> 4 //Three of a kind, where three cards have the same label, and the remaining two cards are each different from any other card in the hand: TTT98
        limitedCounts[0].second == 2 && limitedCounts[1].second == 2 -> 5 //Two pair, where two cards share one label, two other cards share a second label, and the remaining card has a third label: 23432
        limitedCounts[0].second == 2 -> 6 //One pair, where two cards share one label, and the other three cards have a different label from the pair and each other: A23A4
        else -> 7 //High card, where all cards' labels are distinct: 23456
    }
}

private fun cardWeight(card: Char) : Int {
    return when {
        card.isDigit() -> card.toString().toInt()
        card == 'A' -> 14
        card == 'K' -> 13
        card == 'Q' -> 12
        card == 'J' -> 11
        card == 'T' -> 10

        else -> throw UnexpectedException("Unknown card $card")
    }
}

/**
 * Answer: 252052080
 */
private fun solutionA(input: String): Any {
    val hands = input
        .split('\n')
        .map { row -> row
            .split(" ") }
        .map { s -> Hand(s[0],s[1].toInt()) }
        .sorted()
        .reversed()

    var sum = 0
    for (i in hands.indices){
        sum += hands[i].bid * (i+1)
        //println("\"${hands[i].cards}\" == ${rankToName(hands[i].rank)} at ${hands[i].bid} x ${(i+1)} = ${hands[i].bid * (i+1)}")
    }

    return sum
}

private fun adjustedHandWeight(limitedCounts: List<Pair<Char, Int>>): Int {
    val jokerCount = limitedCounts.firstOrNull { l -> l.first == 'J' }?.second ?: 0

    if (jokerCount == 0)
        return handWeight(limitedCounts);

    val countsWithJokersRemoved = limitedCounts.filter { c -> c.first != 'J' }
    val m = countsWithJokersRemoved.map { c -> c.first to c.second }
    return when {
        (if (countsWithJokersRemoved.isEmpty()) 0 else countsWithJokersRemoved[0].second) + jokerCount == 5 -> 1 //Five of a kind, where all five cards have the same label: AAAAA
        countsWithJokersRemoved[0].second + jokerCount == 4 -> 2 //Four of a kind, where four cards have the same label and one card has a different label: AA8AA
        countsWithJokersRemoved[0].second + jokerCount == 3 && countsWithJokersRemoved[1].second == 2 -> 3 //Full house, where three cards have the same label, and the remaining two cards share a different label: 23332
        countsWithJokersRemoved[0].second + jokerCount == 3 -> 4 //Three of a kind, where three cards have the same label, and the remaining two cards are each different from any other card in the hand: TTT98
        countsWithJokersRemoved[0].second + jokerCount == 2 && countsWithJokersRemoved[1].second == 2 -> 5 //Two pair, where two cards share one label, two other cards share a second label, and the remaining card has a third label: 23432
        countsWithJokersRemoved[0].second + jokerCount == 2 -> 6 //One pair, where two cards share one label, and the other three cards have a different label from the pair and each other: A23A4
        else -> 7 //High card, where all cards' labels are distinct: 23456
    }
}

private fun adjustedCardWeight(card: Char) : Int {
    return when {
        card.isDigit() -> card.toString().toInt()
        card == 'A' -> 13
        card == 'K' -> 12
        card == 'Q' -> 11
        card == 'T' -> 10
        card == 'J' -> 1

        else -> throw UnexpectedException("Unknown card $card")
    }
}

/**
 * Answer: 252898370
 */
private fun solutionB(input: String): Any {
    val hands = input
        .split('\n')
        .map { row -> row
            .split(" ") }
        .map { s -> Hand(s[0],s[1].toInt(), ::adjustedCardWeight, ::adjustedHandWeight) }
        .sorted()
        .reversed()

    var sum = 0
    for (i in hands.indices){
        sum += hands[i].bid * (i+1)
        println("\"${hands[i].cards}\" == ${rankToName(hands[i].rank)} at ${hands[i].bid} x ${(i+1)} = ${hands[i].bid * (i+1)}")
    }

    return sum
}