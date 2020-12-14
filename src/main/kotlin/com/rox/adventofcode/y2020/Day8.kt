package com.rox.adventofcode.y2020

import java.lang.RuntimeException

private val inputSample = """
nop +0
acc +1
jmp +4
acc +3
jmp -3
acc -99
acc +1
jmp -4
acc +6
""".trimIndent()

private val inputA = """
acc +17
jmp +1
acc +16
acc +15
jmp +161
acc +37
acc +5
acc -13
nop +134
jmp +426
acc +26
acc +0
jmp +262
acc -1
nop +266
jmp +486
jmp +149
acc +20
acc +27
jmp +564
acc +35
acc +9
acc +31
acc +0
jmp +81
acc -7
nop +142
acc +11
jmp +125
jmp +610
jmp +534
nop +42
jmp +469
acc +48
acc +47
acc -4
jmp +114
jmp +150
nop +311
acc +25
acc +19
jmp -4
acc +48
acc +38
acc -7
jmp +292
acc +19
jmp +386
acc +15
acc -7
acc -8
acc +32
jmp +98
acc +33
jmp +460
acc +7
acc +30
jmp +428
acc -5
acc +30
acc +1
jmp +305
jmp +91
nop -47
acc +23
acc +33
acc +49
jmp +538
acc +19
nop +560
acc +17
jmp +362
jmp +530
jmp +182
acc +50
acc +46
acc -1
nop +60
jmp +39
acc +36
acc +28
acc +49
acc -13
jmp +93
acc -17
acc +20
acc -8
jmp -71
nop +454
acc -1
jmp +365
acc -13
acc -3
acc +5
jmp +479
acc +39
jmp +531
jmp +68
acc -15
acc +10
acc +19
jmp +508
acc +6
nop +301
jmp -9
acc +28
acc +29
nop -65
jmp +116
acc -4
acc -3
jmp -63
acc -5
jmp -71
acc +9
acc +19
jmp +34
jmp +346
nop +484
nop +278
nop +284
jmp +120
acc -15
acc -4
acc +32
acc -3
jmp +461
acc +24
acc -7
jmp -7
acc +15
jmp +349
acc +7
acc +6
acc -15
acc +8
jmp +402
jmp +274
acc +15
acc +28
acc +47
jmp +491
acc +39
acc +37
jmp -65
nop +31
nop +437
nop +183
acc +33
jmp +469
nop +26
jmp +260
jmp +20
acc -19
acc +11
acc +8
jmp +337
acc +41
nop +55
jmp -64
acc +33
acc -5
jmp +79
acc +43
jmp +28
acc +39
jmp +231
jmp +268
acc -10
jmp +360
acc +50
jmp +91
acc +37
acc +16
jmp +170
jmp +162
jmp +426
nop +396
acc +5
jmp +276
acc -14
acc +1
acc -7
acc -17
jmp +399
acc +4
jmp +443
acc +24
acc +44
acc +29
jmp -161
jmp -4
acc -2
acc -9
acc +29
jmp -164
acc +43
acc +17
nop +395
jmp +68
acc -10
jmp +1
jmp -114
acc +6
nop +70
acc +19
jmp +191
jmp +156
acc -11
nop +128
acc +49
acc +6
jmp +390
acc -2
acc -4
acc +11
jmp +257
jmp +71
nop +350
nop +87
jmp +47
acc -10
acc +3
jmp +345
acc +21
acc +6
jmp -89
acc +26
acc +16
acc -18
acc +21
jmp +43
acc +41
acc -4
acc +39
acc +27
jmp +227
acc +21
nop +183
acc +5
jmp +164
acc +36
jmp +6
acc +35
acc -4
acc +30
acc +15
jmp -82
acc +29
acc +8
nop -138
jmp +1
jmp +128
acc +41
jmp +288
acc +12
acc +36
jmp +172
acc +42
acc +14
acc +8
jmp +160
acc -2
nop +200
acc +15
jmp +105
jmp -224
acc +44
nop +161
acc +0
acc +48
jmp +252
acc +35
jmp +354
nop +114
acc +10
acc -18
jmp +268
acc +28
jmp +70
nop -80
acc +44
jmp -220
acc -4
acc +1
acc +43
acc +39
jmp -232
nop -257
acc -3
jmp -195
acc -10
acc +42
acc +47
nop -70
jmp -145
acc +21
jmp +1
acc +19
acc +8
jmp +140
acc +10
acc +20
acc +22
acc +18
jmp -129
acc +40
jmp +244
jmp +1
nop +112
acc +26
acc +4
jmp -162
acc +2
acc +29
jmp +1
jmp -98
acc +11
nop +117
acc +33
acc +36
jmp +208
nop -172
acc +13
acc -4
acc +48
jmp -264
acc +33
acc +37
jmp -256
acc +8
jmp -51
acc +43
acc +19
acc +48
acc +41
jmp +119
acc +46
acc +39
acc +37
jmp +289
acc +48
acc -16
jmp -136
jmp +1
acc +40
jmp -16
nop +246
jmp -300
acc -6
jmp +110
acc +34
nop -315
jmp -316
acc -9
acc +10
acc +19
jmp -347
acc +37
acc +49
acc +45
acc +35
jmp -74
jmp +52
nop -222
jmp -141
acc -8
jmp +153
acc +6
jmp +258
acc +13
acc +13
acc +25
acc +45
jmp +140
acc +12
acc +4
acc +6
acc -13
jmp +122
acc +17
acc -19
jmp -314
acc -9
acc +10
acc -14
acc +40
jmp -345
acc +42
acc -6
acc +10
jmp -231
acc -14
acc +0
acc -4
nop +110
jmp +177
acc +29
acc +38
jmp +121
acc +28
acc +6
acc +12
jmp +98
acc -3
jmp +153
acc +49
acc -1
acc +44
acc -10
jmp +119
jmp -198
acc +40
acc -2
jmp -17
acc +13
acc +41
acc -2
jmp +28
nop -351
jmp -66
acc +4
acc +0
acc +20
nop -393
jmp -137
acc -10
acc -14
jmp +101
jmp -409
jmp +1
acc +17
jmp +173
jmp +105
jmp -46
acc +12
jmp -319
nop -284
nop -340
jmp +16
acc +25
acc -13
acc +48
acc -8
jmp -90
jmp +113
acc +28
acc +20
acc +3
nop -289
jmp +168
acc +27
nop -17
acc -12
jmp -50
jmp -248
acc +38
acc +21
jmp +1
jmp -364
nop +104
jmp +103
jmp -425
jmp +1
acc -1
acc +20
acc +42
jmp +38
acc +20
acc +5
acc +0
acc +20
jmp -118
nop +154
acc +39
acc -1
acc -4
jmp -155
jmp +1
jmp +35
acc +10
acc +7
acc +18
jmp -473
jmp +84
acc +14
acc +20
jmp -295
nop -8
nop -271
acc -19
acc -6
jmp +50
acc +24
acc -5
acc +41
nop -229
jmp -329
acc +40
acc -10
jmp -112
jmp +1
nop -372
jmp -137
jmp -242
acc +39
acc +30
acc +30
jmp -396
acc +4
acc +2
nop -114
acc +30
jmp +114
acc +48
acc -7
acc +28
jmp -462
acc +24
jmp -359
jmp -272
acc -17
jmp +46
jmp -227
acc -3
acc -11
acc +10
acc +16
jmp -5
jmp -387
acc +46
jmp -269
acc -7
acc +30
jmp +1
jmp -519
acc +50
jmp -23
nop -105
jmp -359
acc +19
jmp -106
jmp +26
nop -128
jmp -123
acc -7
acc +12
jmp -474
acc +11
acc +30
jmp -530
acc -17
jmp -504
acc +20
acc +15
acc +27
acc +34
jmp -111
acc +37
acc -6
nop -2
jmp -493
acc +9
jmp -49
jmp -442
acc +0
acc -6
jmp -107
acc +34
acc +39
jmp -166
acc -7
jmp +21
acc +29
jmp -139
acc +22
acc -8
acc +39
jmp -337
jmp -191
acc +0
acc +34
jmp -102
acc -17
acc -10
jmp +8
jmp +7
acc +32
acc -19
acc -6
jmp -553
acc +30
jmp -470
acc +43
acc +2
acc +11
acc -7
jmp +8
acc +39
acc -9
acc +16
jmp -213
nop -70
jmp -341
jmp +5
acc +3
jmp -406
acc +45
jmp -478
nop -409
acc -11
acc +40
jmp -482
acc +0
acc -13
nop -341
acc +30
jmp -79
acc +4
acc +31
acc +10
jmp -389
acc +24
acc +15
acc +36
acc +6
jmp -103
jmp -25
jmp -436
acc +4
jmp -317
jmp -583
acc +12
acc +44
jmp -61
acc -12
acc +21
acc +19
jmp -628
acc +33
acc +37
acc +23
nop -182
jmp +1
""".trimIndent()

fun main() {
    println("Sample Input: ${solutionA(inputSample)}")
 //   println("Test Input: ${solutionA(testInput)}")
    println("Part A: ${solutionA(inputA)}")
    //println("Part B: ${solutionB(inputA)}")
}

/**
 * --- Day 8: Handheld Halting ---
 * Your flight to the major airline hub reaches cruising altitude without incident. While you
 * consider checking the in-flight menu for one of those drinks that come with a little umbrella,
 * you are interrupted by the kid sitting next to you.
 *
 * Their handheld game console won't turn on! They ask if you can take a look.
 *
 * You narrow the problem down to a strange infinite loop in the boot code (your puzzle input) of the
 * device. You should be able to fix it, but first you need to be able to run the code in isolation.
 *
 * The boot code is represented as a text file with one instruction per line of text. Each instruction
 * consists of an operation (acc, jmp, or nop) and an argument (a signed number like +4 or -20).
 *
 * acc increases or decreases a single global value called the accumulator by the value given in the
 * argument. For example, acc +7 would increase the accumulator by 7. The accumulator starts at 0. After
 * an acc instruction, the instruction immediately below it is executed next.
 * jmp jumps to a new instruction relative to itself. The next instruction to execute is found using the
 * argument as an offset from the jmp instruction; for example, jmp +2 would skip the next instruction,
 * jmp +1 would continue to the instruction immediately below it, and jmp -20 would cause the instruction
 * 20 lines above to be executed next.
 * nop stands for No OPeration - it does nothing. The instruction immediately below it is executed next.
 * For example, consider the following program:
 *
 * nop +0
 * acc +1
 * jmp +4
 * acc +3
 * jmp -3
 * acc -99
 * acc +1
 * jmp -4
 * acc +6
 * These instructions are visited in this order:
 *
 * nop +0  | 1
 * acc +1  | 2, 8(!)
 * jmp +4  | 3
 * acc +3  | 6
 * jmp -3  | 7
 * acc -99 |
 * acc +1  | 4
 * jmp -4  | 5
 * acc +6  |
 * First, the nop +0 does nothing. Then, the accumulator is increased from 0 to 1 (acc +1) and jmp +4 sets
 * the next instruction to the other acc +1 near the bottom. After it increases the accumulator from 1 to 2,
 * jmp -4 executes, setting the next instruction to the only acc +3. It sets the accumulator to 5, and jmp -3
 * causes the program to continue back at the first acc +1.
 *
 * This is an infinite loop: with this sequence of jumps, the program will run forever. The moment the program
 * tries to run any instruction a second time, you know it will never terminate.
 *
 * Immediately before the program would run an instruction a second time, the value in the accumulator is 5.
 *
 * Run your copy of the boot code. Immediately before any instruction is executed a second time, what value is
 * in the accumulator?
 *
 * Answer: 1867
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')

    val commands = rows.map { row ->
        with(row.split(' ')) {
            //Convert positive and negative sings
            Pair(this[0], Integer.parseInt(this[1].replace("+", " ").trim()))
        }
    }.toList()

    var environment = Environment(0,0)
    val visited = mutableSetOf<Int>()
    while (!visited.contains(environment.programCounter)){
        visited.add(environment.programCounter)
        val command = commands[environment.programCounter]
        println("${environment.programCounter}: $command -> ${environment.programCounter}")
        environment = when (command.first) {
            "acc" -> Environment(environment.programCounter + 1, environment.accumulator + command.second)
            "jmp" -> Environment(environment.programCounter + command.second, environment.accumulator)
            "nop" -> Environment(environment.programCounter + 1, environment.accumulator)
            else -> throw RuntimeException("Unknown command ${command.first}")
        }
    }

    return environment.accumulator
}

data class Environment(val programCounter: Int = 0, val accumulator: Int = 0)

/**
 *
 * Answer: ???
 */
private fun solutionB(input: String): Any {
    input.split('\n')

    return input
}