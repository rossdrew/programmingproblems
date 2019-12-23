package com.rox.adventofcode.y2019

private val inputA = """1002,4,3,4,33""".trimIndent()

fun main(args: Array<String>) {
    println("Part A: ${solutionA(inputA)}")
    println("Part B: ${solutionB(inputA)}")
}

/**
 * --- Day 5: Sunny with a Chance of Asteroids ---
You're starting to sweat as the ship makes its way toward Mercury. The Elves suggest that you get the air conditioner
working by upgrading your ship computer to support the Thermal Environment Supervision Terminal.

The Thermal Environment Supervision Terminal (TEST) starts by running a diagnostic programAndPC (your puzzle input).
The TEST diagnostic programAndPC will run on your existing Intcode computer after a few modifications:

First, you'll need to add two new instructions:

Opcode 3 takes a single integer as input and saves it to the position given by its only parameter. For example, the
instruction 3,50 would take an input value and store it at address 50.
Opcode 4 outputs the value of its only parameter. For example, the instruction 4,50 would output the value at
address 50.
Programs that use these instructions will come with documentation that explains what should be connected to the input
and output. The programAndPC 3,0,4,0,99 outputs whatever it gets as input, then halts.

Second, you'll need to add support for parameter modes:

Each parameter of an instruction is handled based on its parameter mode. Right now, your ship computer already
understands parameter mode 0, position mode, which causes the parameter to be interpreted as a position - if the
parameter is 50, its value is the value stored at address 50 in memory. Until now, all parameters have been in
position mode.

Now, your ship computer will also need to handle parameters in mode 1, immediate mode. In immediate mode, a parameter
is interpreted as a value - if the parameter is 50, its value is simply 50.

Parameter modes are stored in the same value as the instruction's opcode. The opcode is a two-digit number based only
on the ones and tens digit of the value, that is, the opcode is the rightmost two digits of the first value in an
instruction. Parameter modes are single digits, one per parameter, read right-to-left from the opcode: the first
parameter's mode is in the hundreds digit, the second parameter's mode is in the thousands digit, the third
parameter's mode is in the ten-thousands digit, and so on. Any missing modes are 0.

For example, consider the programAndPC 1002,4,3,4,33.

The first instruction, 1002,4,3,4, is a multiply instruction - the rightmost two digits of the first value, 02,
indicate opcode 2, multiplication. Then, going right to left, the parameter modes are 0 (hundreds digit), 1
(thousands digit), and 0 (ten-thousands digit, not present and therefore zero):

ABCDE
1002

DE - two-digit opcode,      02 == opcode 2
C - mode of 1st parameter,  0 == position mode
B - mode of 2nd parameter,  1 == immediate mode
A - mode of 3rd parameter,  0 == position mode,
omitted due to being a leading zero
This instruction multiplies its first two parameters. The first parameter, 4 in position mode, works like it did
before - its value is the value stored at address 4 (33). The second parameter, 3 in immediate mode, simply has value
3. The result of this operation, 33 * 3 = 99, is written according to the third parameter, 4 in position mode, which
also works like it did before - 99 is written to address 4.

Parameters that an instruction writes to will never be in immediate mode.

Finally, some notes:

It is important to remember that the instruction pointer should increase by the number of values in the instruction
after the instruction finishes. Because of the new instructions, this amount is no longer always 4.
Integers can be negative: 1101,100,-1,4,0 is a valid programAndPC (find 100 + -1, store the result in position 4).
The TEST diagnostic programAndPC will start by requesting from the user the ID of the system to test by running an input
instruction - provide it 1, the ID for the ship's air conditioner unit.

It will then perform a series of diagnostic tests confirming that various parts of the Intcode computer, like
parameter modes, function correctly. For each test, it will run an output instruction indicating how far the result
of the test was from the expected value, where 0 means the test was successful. Non-zero outputs mean that a
function is not working correctly; check the instructions that were run before the output instruction to see which
one failed.

Finally, the programAndPC will output a diagnostic code and immediately halt. This final output isn't an error; an output
followed immediately by a halt means the programAndPC finished. If all outputs were zero except the diagnostic code,
the diagnostic programAndPC ran successfully.

After providing 1 to the only input instruction and passing all the tests, what diagnostic code does the programAndPC
produce?
 */
private fun solutionA(input : String) : Int? {
    val program = input.split(',').map { it.toInt() }

    throw RuntimeException("Not Implemented")
}


/**
 */
private fun solutionB(input : String) : Int? {
    val program = input.split(',').map { it.toInt() }

    throw RuntimeException("Not Implemented")
}


/**
 * Return value of <code>mem@location</code> where location is a pointer at <code>mem@pointerLocation</code>
 */
private fun get(pointerLocation: Int, mem: MutableList<Int>) : Int {
    return mem[mem[pointerLocation]]
}

/**
 * Put <code>value</code> in <code>mem@location</code> where location is a pointer at <code>mem@pointerLocation</code>
 */
private fun put(value: Int, pointerLocation: Int, mem: MutableList<Int>) {
    mem[mem[pointerLocation]] = value
}

/**
 * XXX: I want to be able to name programs arguments so that my argument name isn't "and"
 */
enum class Mode (val programAndPC: (MutableList<Int>, Int) -> Int) {
    /** Return the value at location l in programAndPC p */
    IMMEDIATE({ p,l -> p[l] }),
    /** Return the value referred to at location l in programAndPC p */
    POSITION({ p,l -> get(l,p)})
}

private fun runProgram(program: MutableList<Int>, noun: Int, verb: Int) : Int {
    program[1] = noun
    program[2] = verb

    var programCounter = 0
    while (programCounter < program.size){
        val opcode = program[programCounter].toString()
        val instruction = opcode.takeLast(2).toInt()
        val paramModes = opcode.substring(0, opcode.length - 3).reversed().map { modeChar ->
            when (modeChar) {
                '0' -> { Mode.POSITION}
                '1' -> { Mode.IMMEDIATE }
                else -> throw RuntimeException("Unknown mode '$modeChar'")
            }
        }
        //This (and above) could all be folded into one map-like operation functionally, I'm sure
        val param1 = paramModes[0].programAndPC(program, programCounter+1)
        val param2 = paramModes[1].programAndPC(program, programCounter+2)

        when (instruction) {
            //ADD
            1 -> {
                put(param1 + param2, programCounter+3, program)
                programCounter += 4
            }

            //MULTI
            2 -> {
                put(param1 * param2, programCounter+3, program)
                programCounter += 4
            }

            //LOAD
            3 -> {
                program[program[programCounter+1]] = fromInput
                programCounter += 2
            }

            //ECHO
            4 -> {
                toOutput = program[program[programCounter+1]]
                programCounter += 2
            }

            99 -> return program[0]
            else -> throw RuntimeException("Unknown opcode '${program[programCounter]}'@${programCounter}")
        }
    }

    throw RuntimeException("Unexpected programAndPC termination")
}