package com.rox.adventofcode.y2022

import com.rox.adventofcode.puzzleInputFromFile
import java.math.BigInteger
import java.rmi.UnexpectedException

private val inputSample = """
Monkey 0:
  Starting items: 79, 98
  Operation: new = old * 19
  Test: divisible by 23
    If true: throw to monkey 2
    If false: throw to monkey 3

Monkey 1:
  Starting items: 54, 65, 75, 74
  Operation: new = old + 6
  Test: divisible by 19
    If true: throw to monkey 2
    If false: throw to monkey 0

Monkey 2:
  Starting items: 79, 60, 97
  Operation: new = old * old
  Test: divisible by 13
    If true: throw to monkey 1
    If false: throw to monkey 3

Monkey 3:
  Starting items: 74
  Operation: new = old + 3
  Test: divisible by 17
    If true: throw to monkey 0
    If false: throw to monkey 1
""".trimIndent()

fun main() {
    //println("Sample Input A: ${solutionA(inputSample)}")
    //println("Sample Input B: ${solutionB(inputSample)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2022/Day11.input"))}")
    //println("Part B: ${solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y202X/DayX.input"))}")
}

/**
 *
 *
 * Answer: 111210
 */
private fun solutionA(input: String): Any {
    val groups = input.split("\n\n")

    val monkeys = mutableMapOf<Int, Monkey>()
    val inspections = mutableMapOf<Int,Int>()

    groups.map { monkey ->
        val line = monkey.split("\n")
        val name = line[0].subSequence("Monkey ".length, line[0].length-1).toString().toInt()
        val items = line[1].subSequence(" Starting items: ".length, line[1].length).split(",").map { item -> Integer.parseInt(item.trim()) }
        val ifTrue = (line[4].subSequence("    If true: throw to monkey ".length, line[4].length) as String).toInt()
        val ifFalse = (line[5].subSequence("    If false: throw to monkey ".length, line[5].length) as String).toInt()
        val testDivisor = Integer.parseInt(line[3].subSequence(" Test: divisible by ".length, line[3].length).trim().toString())
        val testLogic = { worry: Int -> if (worry % testDivisor == 0) ifTrue else ifFalse }
        val operation = line[2].subSequence(" Operation: new = ".length, line[2].length).trim().split(" ")
        val lhsArg = operation[0]
        val op = operation[1]
        val rhsArg = operation[2]

        val operationLogic = { item: Int ->
            val lhs = if (lhsArg == "old") item else lhsArg.toInt()
            val rhs = if (rhsArg == "old") item else rhsArg.toInt()

            when (op){
                "+" -> lhs + rhs
                "*" -> lhs * rhs
                else -> throw UnexpectedException("Unknown operator '$op'")
            }
        }

        monkeys[name] = Monkey(name, items, operationLogic, testLogic)
        inspections[name] = 0
    }

    for (round in 1 .. 20){
        for (monkeyName in 0 until monkeys.keys.size){
            val monkey = monkeys[monkeyName]
            val items = monkey?.items as MutableList
            for (itemIndex in items.indices){
                val item = items[itemIndex]
                val inspectedValue = monkey.inspect.invoke(item)
                //divide worry by 3 and round down/
                val safeItem = inspectedValue / 3
                val receivingMonkey = monkey.testItem.invoke(safeItem)
                (monkeys[receivingMonkey]?.items as MutableList).add(safeItem)
                inspections[monkeyName] = (inspections[monkeyName] as Int) + 1
            }

            monkey.items = mutableListOf()
        }
    }

//    inspections.forEach{ monkey ->
//        println("Monkey ${monkey.key} inspected items ${monkey.value} times.")
//    }
    return inspections.values.sorted().takeLast(2).reduce{ a, v -> a*v}
}

val lcd = BigInteger("9699690") //of 2,7,3,11,17,5,13,19

/**
 *
 * Answer: ???
 */
private fun solutionB(input: String): Any {
    val groups = input.split("\n\n")

    val (monkeys, inspections) = parseMonkeys(groups)

    for (round in 1 .. 10000){
        for (monkeyName in 0 until monkeys.keys.size){
            val monkey = monkeys[monkeyName]
            val monkeysItems = monkey?.items as MutableList
            for (itemIndex in monkeysItems.indices){
                val item = monkeysItems[itemIndex]
                val inspectedValue = monkey.inspect.invoke(item)
                //make number size manageable
                val constrainedItem = inspectedValue.mod(lcd)
                val receivingMonkey = monkey.testItem.invoke(constrainedItem)
                (monkeys[receivingMonkey]?.items as MutableList).add(constrainedItem)
                inspections[monkeyName] = (inspections[monkeyName] as Long) + 1
            }

            monkey.items = mutableListOf()
        }

        when (round){
            1,20,1000,2000,3000,4000,5000,6000,7000,8000,9000,10000 -> {
                println("$round:")
                inspections.forEach{ monkey ->
                    println("\tMonkey ${monkey.key} inspected items ${monkey.value} times.")
                }
            }
            else -> {}
        }
    }

    return inspections.values.sorted().takeLast(2).reduce{ a, v -> a*v}
}

private fun parseMonkeys(groups: List<String>): Pair<MutableMap<Int, BigWorryMonkey>, MutableMap<Int, Long>> {
    val monkeys = mutableMapOf<Int, BigWorryMonkey>()
    val inspections = mutableMapOf<Int, Long>()

    groups.map { monkey ->
        val line = monkey.split("\n")
        val name = line[0].subSequence("Monkey ".length, line[0].length - 1).toString().toInt()
        val items = line[1].subSequence(" Starting items: ".length, line[1].length).split(",")
            .map { item -> BigInteger(item.trim()) }
        val ifTrue = (line[4].subSequence("    If true: throw to monkey ".length, line[4].length) as String).toInt()
        val ifFalse = (line[5].subSequence("    If false: throw to monkey ".length, line[5].length) as String).toInt()
        val testDivisor = BigInteger(line[3].subSequence(" Test: divisible by ".length, line[3].length).trim().toString())
        val testLogic = { worry: BigInteger -> if (worry.mod(testDivisor) == BigInteger.ZERO) ifTrue else ifFalse }
        val operation = line[2].subSequence(" Operation: new = ".length, line[2].length).trim().split(" ")
        val lhsArg = operation[0]
        val op = operation[1]
        val rhsArg = operation[2]

        val operationLogic = { item: BigInteger ->
            val lhs = if (lhsArg == "old") item else BigInteger(lhsArg)
            val rhs = if (rhsArg == "old") item else BigInteger(rhsArg)

            when (op){
                "+" -> lhs + rhs
                "*" -> lhs * rhs
                else -> throw UnexpectedException("Unknown operator '$op'")
            }
        }

        monkeys[name] = BigWorryMonkey(name, items, operationLogic, testLogic)
        inspections[name] = 0
    }
    return Pair(monkeys, inspections)
}

data class Monkey(val id: Int,
                  var items: List<Int>,
                  val inspect: (Int)->Int, //Item to
                  val testItem: (Int)->Int)

data class BigWorryMonkey(val id: Int,
                          var items: List<BigInteger>,
                          val inspect: (BigInteger)->BigInteger,
                          val testItem: (BigInteger)->Int)
