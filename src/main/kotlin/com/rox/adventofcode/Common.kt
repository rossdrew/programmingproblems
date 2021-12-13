package com.rox.adventofcode

import java.io.File

fun puzzleInputFromFile(fileName: String): String = File(fileName).readText(Charsets.UTF_8)

fun <TypeA, TypeB> cartesianProduct(A: Collection<TypeA>, B: Collection<TypeB>): List<Pair<TypeA, TypeB>> {
    return A.flatMap {
            a -> B.map {
                b -> a to b
            }
    }
}