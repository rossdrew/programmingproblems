package com.rox.adventofcode

import java.io.File

fun puzzleInputFromFile(fileName: String): String = File(fileName).readText(Charsets.UTF_8)