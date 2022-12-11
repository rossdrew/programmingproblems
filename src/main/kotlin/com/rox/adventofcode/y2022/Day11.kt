package com.rox.adventofcode.y2022

import java.math.BigInteger
import java.rmi.UnexpectedException
import java.text.SimpleDateFormat
import java.util.*

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
    println("Sample Input B: ${solutionB(inputSample)}")
    //println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2022/Day11.input"))}")
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
        val operation = line[2].subSequence(" Operation: new = ".length, line[2].length).trim().toString()
        val test = line[3].subSequence(" Test: ".length, line[3].length).trim().toString()
        val ifTrue = (line[4].subSequence("    If true: throw to monkey ".length, line[4].length) as String).toInt()
        val ifFalse = (line[5].subSequence("    If false: throw to monkey ".length, line[5].length) as String).toInt()

        monkeys[name] = Monkey(name, items, operation, test, ifTrue, ifFalse)
        inspections[name] = 0
    }

    for (round in 1 .. 20){
        for (monkeyName in 0 until monkeys.keys.size){
            val monkey = monkeys[monkeyName]
            val items = monkey?.items as MutableList
            for (itemIndex in items.indices){
                val item = items[itemIndex]
                //inspect
                val inspectedValue = performOperation(monkey.op, item)
                //divide worry by 3 and round down/
                val safeItem = inspectedValue / 3
                //test worry level
                if (performTest(monkey.test, safeItem)){
                    (monkeys[monkey.ifTrue]?.items as MutableList).add(safeItem)
                    //println("Round$round: Monkey $monkeyName passes $item ($safeItem) to ${monkey.ifTrue}")
                }else{
                    (monkeys[monkey.ifFalse]?.items as MutableList).add(safeItem)
                    //println("Round$round: Monkey $monkeyName passes $item ($safeItem) to ${monkey.ifFalse}")
                }
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

    val monkeys = mutableMapOf<Int, BigWorryMonkey>()
    val inspections = mutableMapOf<Int,Long>()

    groups.map { monkey ->
        val line = monkey.split("\n")
        val name = line[0].subSequence("Monkey ".length, line[0].length-1).toString().toInt()
        val items = line[1].subSequence(" Starting items: ".length, line[1].length).split(",").map { item -> BigInteger(item.trim()) }
        val operation = line[2].subSequence(" Operation: new = ".length, line[2].length).trim().toString()
        val test = line[3].subSequence(" Test: ".length, line[3].length).trim().toString()
        val ifTrue = (line[4].subSequence("    If true: throw to monkey ".length, line[4].length) as String).toInt()
        val ifFalse = (line[5].subSequence("    If false: throw to monkey ".length, line[5].length) as String).toInt()

        monkeys[name] = BigWorryMonkey(name, items, operation, test, ifTrue, ifFalse)
        inspections[name] = 0
    }

    val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
    System.out.println(" Starting at "+sdf.format(Date()))



    for (round in 1 .. 10000){
        for (monkeyName in 0 until monkeys.keys.size){
            val monkey = monkeys[monkeyName]
            val items = monkey?.items as MutableList
            for (itemIndex in items.indices){
                val item = items[itemIndex]
                //inspect
                val inspectedValue = performBigOperation(monkey.op, item)
                //make number size managemable
                val constrainedItem = inspectedValue.mod(lcd)
                //test worry level
                if (performBigTest(monkey.test, constrainedItem)){
                    (monkeys[monkey.ifTrue]?.items as MutableList).add(constrainedItem)
                    //println("Round$round: Monkey $monkeyName passes $item ($safeItem) to ${monkey.ifTrue}")
                }else{
                    (monkeys[monkey.ifFalse]?.items as MutableList).add(constrainedItem)
                    //println("Round$round: Monkey $monkeyName passes $item ($safeItem) to ${monkey.ifFalse}")
                }
                inspections[monkeyName] = (inspections[monkeyName] as Long) + 1
            }

            monkey.items = mutableListOf()
        }
        System.out.println("Round $round completed at "+sdf.format(Date()))
        when (round){
            1,20,1000,2000,3000,4000,5000,6000,7000,8000,9000,10000 -> {
                inspections.forEach{ monkey ->
                    println("\tMonkey ${monkey.key} inspected items ${monkey.value} times.")
                }
            }
            else -> {}
        }
    }

    return inspections.values.sorted().takeLast(2).reduce{ a, v -> a*v}
}

data class Monkey(val id: Int,
                  var items: List<Int>,
                  val op: String,
                  val test: String,
                  val ifTrue: Int,
                  val ifFalse: Int)

data class BigWorryMonkey(val id: Int,
                          var items: List<BigInteger>,
                          val op: String,
                          val test: String,
                          val ifTrue: Int,
                          val ifFalse: Int)

fun performBigOperation(instr: String, param: BigInteger): BigInteger {
    val split = instr.split(" ")
    val lhsArg = split[0]
    val op = split[1]
    val rhsArg = split[2]

    val lhs = if (lhsArg == "old") param else BigInteger(lhsArg)
    val rhs = if (rhsArg == "old") param else BigInteger(rhsArg)

    return when (op){
        "+" -> lhs.plus(rhs)
        "*" -> lhs.multiply(rhs)
        else -> throw UnexpectedException("Unknown operator '$op'")
    }
}

fun performOperation(instr: String, param: Int): Int{
    val split = instr.split(" ")
    val lhsArg = split[0]
    val op = split[1]
    val rhsArg = split[2]

    val lhs = if (lhsArg == "old") param else lhsArg.toInt()
    val rhs = if (rhsArg == "old") param else rhsArg.toInt()

    return when (op){
        "+" -> lhs + rhs
        "*" -> lhs * rhs
        else -> throw UnexpectedException("Unknown operator '$op'")
    }
}

fun performBigTest(instr: String, param: BigInteger): Boolean{
    return when {
        instr.startsWith("divisible by ")->{
            val by = instr.split(" ")[2].trim().toBigInteger()
            return param.mod(by) == BigInteger.ZERO
        }
        else -> throw UnexpectedException("Test not recognised '$instr'")
    }
}

fun performTest(instr: String, param: Int): Boolean{
    return when {
        instr.startsWith("divisible by ")->{
            val by = instr.split(" ")[2].trim().toInt()
            return param % by == 0
        }
        else -> throw UnexpectedException("Test not recognised '$instr'")
    }
}