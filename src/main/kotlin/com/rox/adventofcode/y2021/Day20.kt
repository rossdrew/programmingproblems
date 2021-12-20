package com.rox.adventofcode.y2021

import com.rox.adventofcode.cartesianProduct
import com.rox.adventofcode.parseGrid
import com.rox.adventofcode.puzzleInputFromFile

private val inputSample = """
..#.#..#####.#.#.#.###.##.....###.##.#..###.####..#####..#....#..#..##..###..######.###...####..#..#####..##..#.#####...##.#.#..#.##..#.#......#.###.######.###.####...#.##.##..#..#..#####.....#.#....###..#.##......#.....#..#..#..##..#...##.######.####.####.#.#...#.......#..#.#.#...####.##.#......#..#...##.#.##..#...##.#.##..###.#......#.#.......#.#.#.####.###.##...#.....####.#..#..#.##.#....##..#.####....##...##..#...#......#.#.......#.......##..####..#...#.#.#...##..#.#..###..#####........#..####......#..#

#..#.
#....
##..#
..#..
..###
""".trimIndent()

fun main() {
    println("Sample Input A: ${solutionA(inputSample)}")
    //println("Sample Input B: ${solutionB(inputSample)}")
    //println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2021/day20.alt.input"))}")
    println("Part A (exp 3351): ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2021/day20.alt.input"))}") //3351 expected
    //println("Part B: ${com.rox.adventofcode.y2021.solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2021/day20.input"))}")
}

/**
 * --- Day 20: Trench Map ---
 * With the scanners fully deployed, you turn their attention to mapping the floor of the ocean trench.
 *
 * When you get back the image from the scanners, it seems to just be random noise. Perhaps you can combine an image
 * enhancement algorithm and the input image (your puzzle input) to clean it up a little.
 *
 * For example:
 *
 * ..#.#..#####.#.#.#.###.##.....###.##.#..###.####..#####..#....#..#..##..##
 * #..######.###...####..#..#####..##..#.#####...##.#.#..#.##..#.#......#.###
 * .######.###.####...#.##.##..#..#..#####.....#.#....###..#.##......#.....#.
 * .#..#..##..#...##.######.####.####.#.#...#.......#..#.#.#...####.##.#.....
 * .#..#...##.#.##..#...##.#.##..###.#......#.#.......#.#.#.####.###.##...#..
 * ...####.#..#..#.##.#....##..#.####....##...##..#...#......#.#.......#.....
 * ..##..####..#...#.#.#...##..#.#..###..#####........#..####......#..#
 *
 * #..#.
 * #....
 * ##..#
 * ..#..
 * ..###
 * The first section is the image enhancement algorithm. It is normally given on a single line, but it has been wrapped
 * to multiple lines in this example for legibility. The second section is the input image, a two-dimensional grid of
 * light pixels (#) and dark pixels (.).
 *
 * The image enhancement algorithm describes how to enhance an image by simultaneously converting all pixels in the
 * input image into an output image. Each pixel of the output image is determined by looking at a 3x3 square of pixels
 * centered on the corresponding input image pixel. So, to determine the value of the pixel at (5,10) in the output
 * image, nine pixels from the input image need to be considered: (4,9), (4,10), (4,11), (5,9), (5,10), (5,11), (6,9),
 * (6,10), and (6,11). These nine input pixels are combined into a single binary number that is used as an index in the
 * image enhancement algorithm string.
 *
 * For example, to determine the output pixel that corresponds to the very middle pixel of the input image, the nine
 * pixels marked by [...] would need to be considered:
 *
 * # . . # .
 * #[. . .].
 * #[# . .]#
 * .[. # .].
 * . . # # #
 * Starting from the top-left and reading across each row, these pixels are ..., then #.., then .#.; combining these
 * forms ...#...#.. By turning dark pixels (.) into 0 and light pixels (#) into 1, the binary number 000100010 can be
 * formed, which is 34 in decimal.
 *
 * The image enhancement algorithm string is exactly 512 characters long, enough to match every possible 9-bit binary
 * number. The first few characters of the string (numbered starting from zero) are as follows:
 *
 * 0         10        20        30  34    40        50        60        70
 * |         |         |         |   |     |         |         |         |
 * ..#.#..#####.#.#.#.###.##.....###.##.#..###.####..#####..#....#..#..##..##
 * In the middle of this first group of characters, the character at index 34 can be found: #. So, the output pixel in
 * the center of the output image should be #, a light pixel.
 *
 * This process can then be repeated to calculate every pixel of the output image.
 *
 * Through advances in imaging technology, the images being operated on here are infinite in size. Every pixel of the
 * infinite output image needs to be calculated exactly based on the relevant pixels of the input image. The small
 * input image you have is only a small region of the actual infinite input image; the rest of the input image consists
 * of dark pixels (.). For the purposes of the example, to save on space, only a portion of the infinite-sized input
 * and output images will be shown.
 *
 * The starting input image, therefore, looks something like this, with more dark pixels (.) extending forever in every
 * direction not shown here:
 *
 * ...............
 * ...............
 * ...............
 * ...............
 * ...............
 * .....#..#......
 * .....#.........
 * .....##..#.....
 * .......#.......
 * .......###.....
 * ...............
 * ...............
 * ...............
 * ...............
 * ...............
 * By applying the image enhancement algorithm to every pixel simultaneously, the following output image can be
 * obtained:
 *
 * ...............
 * ...............
 * ...............
 * ...............
 * .....##.##.....
 * ....#..#.#.....
 * ....##.#..#....
 * ....####..#....
 * .....#..##.....
 * ......##..#....
 * .......#.#.....
 * ...............
 * ...............
 * ...............
 * ...............
 * Through further advances in imaging technology, the above output image can also be used as an input image! This
 * allows it to be enhanced a second time:
 *
 * ...............
 * ...............
 * ...............
 * ..........#....
 * ....#..#.#.....
 * ...#.#...###...
 * ...#...##.#....
 * ...#.....#.#...
 * ....#.#####....
 * .....#.#####...
 * ......##.##....
 * .......###.....
 * ...............
 * ...............
 * ...............
 * Truly incredible - now the small details are really starting to come through. After enhancing the original input
 * image twice, 35 pixels are lit.
 *
 * Start with the original input image and apply the image enhancement algorithm twice, being careful to account for
 * the infinite size of the images. How many pixels are lit in the resulting image?
 *
 * Answer: 5575 (Too high)
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')

    val enhancementAlgo = rows[0]
    val inputImage = parseGrid(rows.subList(2, rows.size)) { inputCharacter ->
        when (inputCharacter) {
            "." -> 0
            "#" -> 1
            else -> throw RuntimeException("Unexpected input '$inputCharacter'")
        }
    }

    //Add "infinite" padding
    val enhanced1 = enhance(inputImage, enhancementAlgo, 10)
    val enhanced2 = enhance(enhanced1, enhancementAlgo, 0)
    //Remove random outer layer
    val sanitised =  enhanced2.copyOfRange(1,enhanced2.size-1).map { row -> row.copyOfRange(1, row.size-1) as IntArray }

    printGrid(inputImage, "Input Image")
    printGrid(enhanced1, "Enhanced v1")
    printGrid(enhanced2, "Enhanced v2")
    printGrid(sanitised.toTypedArray(), "Sanitised")

    return sanitised.sumBy { row -> row.sum() }
}

private fun printGrid(inputImage: Array<IntArray>, name: String) {
    println("$name:")
    for (row in inputImage.indices) {
        for (col in inputImage.indices) {
            if (inputImage[row][col] == 1) {
                print("#")
            } else {
                print(".")
            }
        }
        print("`\n")
    }
}

private fun enhance(inputImage: Array<IntArray>, enhancementAlgo: String, paddingSize: Int): Array<IntArray> {
    //input image with empty padding around it
    var paddedInput = Array(inputImage.size + (paddingSize*2)) { IntArray(inputImage[0].size + (paddingSize*2)) { 0 } }
    for (row in inputImage.indices) {
        for (col in inputImage[0].indices) {
            paddedInput[row + paddingSize][col + paddingSize] = inputImage[row][col]
        }
    }

    var outputImage = Array(paddedInput.size) { IntArray(paddedInput[0].size) { 0 } }
    for (row in paddedInput.indices) {
        for (col in paddedInput[0].indices) {
            val neighbours =
                cartesianProduct(listOf(row - 1, row, row + 1) /*your boat*/, listOf(col - 1, col, col + 1))
            val binary = neighbours.map { coord ->
                if (coord.first in paddedInput.indices && coord.second in paddedInput[0].indices){
                    paddedInput[coord.first][coord.second]
                } else {
                    0
                }
            }.joinToString("")
            val enhancementIndex = Integer.parseInt(binary, 2)
            outputImage[row][col] = when (enhancementAlgo[enhancementIndex]) {
                '.' -> 0
                '#' -> 1
                else -> throw RuntimeException("Unexpected output '$enhancementAlgo[enhancementIndex]'")
            }
        }
    }
    return outputImage
}

/**
 *
 * Answer: ???
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')

    return input
}

