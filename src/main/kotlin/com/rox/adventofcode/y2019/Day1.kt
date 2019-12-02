package com.rox.adventofcode.y2019

import java.lang.RuntimeException
import kotlin.math.floor

private val inputA = """
71764
58877
107994
72251
74966
87584
118260
144961
86889
136710
52493
131045
101496
124341
71936
88967
106520
125454
113463
81854
99918
105217
120383
61105
103842
125151
139191
143365
102168
69845
57343
93401
140910
121997
107964
53358
57397
141456
94052
127395
99180
143838
130749
126809
70165
92007
83343
55163
95270
101323
99877
105721
129657
61213
130120
108549
90539
111382
61665
95121
53216
103144
134367
101251
105118
73220
56270
50846
77314
59134
98495
113654
89711
68676
98991
109068
129630
58999
132095
98685
91762
88589
73846
124940
106944
133882
104073
78475
76545
144728
72449
118320
65363
83523
124634
96222
128252
112848
139027
108208
""".trimIndent()

fun main(args: Array<String>) {
    println("Part A: ${solutionA(inputA)}")
    println("Part B: ${solutionB(inputA)}")
}

/**
 * --- Day 1: The Tyranny of the Rocket Equation ---
 * Santa has become stranded at the edge of the Solar System while delivering presents to other planets!
 * To accurately calculate his position in space, safely align his warp drive, and return to Earth in time
 * to save Christmas, he needs you to bring him measurements from fifty stars.
 *
 * Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar;
 * the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!
 *
 * The Elves quickly load you into a spacecraft and prepare to launch.
 *
 * At the first Go / No Go poll, every Elf is Go until the Fuel Counter-Upper. They haven't determined the
 * amount of fuel required yet.
 *
 * Fuel required to launch a given module is based on its mass. Specifically, to find the fuel required for
 * a module, take its mass, divide by three, round down, and subtract 2.
 *
 * For example:
 *
 * For a mass of 12, divide by 3 and round down to get 4, then subtract 2 to get 2.
 * For a mass of 14, dividing by 3 and rounding down still yields 4, so the fuel required is also 2.
 * For a mass of 1969, the fuel required is 654.
 * For a mass of 100756, the fuel required is 33583.
 * The Fuel Counter-Upper needs to know the total fuel requirement. To find it, individually calculate the
 * fuel needed for the mass of each module (your puzzle input), then add together all the fuel values.
 *
 * What is the sum of the fuel requirements for all of the modules on your spacecraft?
 *
 * Answer: 3299598
 */
private fun solutionA(input : String) : Any {
    val requirements = input.split('\n').map { basicFuelRequirementsFor(it.toDouble())}
    return requirements.sum()
}

/**
 * Given the mass, calculate the fuel required to launch
 */
private fun basicFuelRequirementsFor(mass: Double): Double {
    return floor(mass / 3) - 2
}

/**
 * --- Part Two ---
 * During the second Go / No Go poll, the Elf in charge of the Rocket Equation Double-Checker
 * stops the launch sequence. Apparently, you forgot to include additional fuel for the fuel you just added.
 *
 * Fuel itself requires fuel just like a module - take its mass, divide by three, round down,
 * and subtract 2. However, that fuel also requires fuel, and that fuel requires fuel, and so on.
 * Any mass that would require negative fuel should instead be treated as if it requires zero fuel;
 * the remaining mass, if any, is instead handled by wishing really hard, which has no mass and is
 * outside the scope of this calculation.
 *
 * So, for each module mass, calculate its fuel and add it to the total. Then, treat the fuel amount
 * you just calculated as the input mass and repeat the process, continuing until a fuel requirement is
 * zero or negative. For example:
 *
 * A module of mass 14 requires 2 fuel. This fuel requires no further fuel (2 divided by 3 and rounded
 * down is 0, which would call for a negative fuel), so the total fuel required is still just 2.
 * At first, a module of mass 1969 requires 654 fuel. Then, this fuel requires 216 more fuel (654 / 3 - 2).
 * 216 then requires 70 more fuel, which requires 21 fuel, which requires 5 fuel, which requires no
 * further fuel. So, the total fuel required for a module of mass 1969 is 654 + 216 + 70 + 21 + 5 = 966.
 * The fuel required by a module of mass 100756 and its fuel is:
 * 33583 + 11192 + 3728 + 1240 + 411 + 135 + 43 + 12 + 2 = 50346.
 * What is the sum of the fuel requirements for all of the modules on your spacecraft when also taking
 * into account the mass of the added fuel? (Calculate the fuel requirements for each module separately,
 * then add them all up at the end.)
 *
 * Answer: 4946546
 */
private fun solutionB(input : String) : Any {
    val requirements = input.split('\n').map { completeFuelRequirementsFor(it.toDouble())}
    return requirements.sum()
}


/**
 * Given the mass, calculate the fuel required to launch, including the weight of the fuel
 */
private fun completeFuelRequirementsFor(mass: Double): Double {
    var fuelAccumulator = basicFuelRequirementsFor(mass)
    var additionalRequirements = fuelAccumulator

    while (basicFuelRequirementsFor(additionalRequirements) > 0){
        additionalRequirements = basicFuelRequirementsFor(additionalRequirements)
        fuelAccumulator += additionalRequirements
    }
    return fuelAccumulator
}