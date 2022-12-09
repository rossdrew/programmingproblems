package com.euler

import java.lang.Integer.max
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

/**
 * A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with
 * denominators 2 to 10 are given:
 *
 * <sup>1</sup>/<sub>2</sub>= 0.5<br/>
 * <sup>1</sup>/<sub>3</sub>= 0.(3)<br/>
 * <sup>1</sup>/<sub>4</sub>= 0.25<br/>
 * <sup>1</sup>/<sub>5</sub>= 0.2<br/>
 * <sup>1</sup>/<sub>6</sub>= 0.1(6)<br/>
 * <sup>1</sup>/<sub>7</sub>= 0.(142857)<br/>
 * <sup>1</sup>/<sub>8</sub>= 0.125<br/>
 * <sup>1</sup>/<sub>9</sub>= 0.(1)<br/>
 * <sup>1</sup>/<sub>10</sub>= 0.1<br/>
 *
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that <sup>1</sup>/<sub>7</sub>
 * has a 6-digit recurring cycle.
 * Find the value of <i>d</i> &lt; 1000 for which <sup>1</sup>/<sub><i>d</i></sub> contains the longest recurring
 * cycle in its decimal fraction part.
 *
 * Answer: NOT 63,51,982
 */

fun main() {
    val numerator = BigDecimal.ONE
    var maxRepeat = 0
//17 should return 16
    (3..999).map { denominator ->
        try {
            val n = numerator.divide(BigDecimal(denominator), MathContext(2000, RoundingMode.HALF_EVEN))
            val decimalPortion = n.toPlainString().subSequence(2 until n.toPlainString().length)
            //println("$denominator: $decimalPortion")
            //There's at least two characters and they aren't infinitely repeating
            if (decimalPortion.length > 2 && decimalPortion.chars().distinct().count() > 1){
            //is there a recurring cycle?
                for (chunkSize in 10 .. (decimalPortion.length/2)){
                    val chunks = decimalPortion.chunked(chunkSize)
                    //TODO this is not finding some
                    if (chunks[0] == chunks[1]){
                        //println("$denominator (${chunkSize>maxRepeat}): ${chunks[0]}")
                        maxRepeat = max(maxRepeat, chunkSize)
                        break
                    }
                }
            }
        } catch (e: ArithmeticException){
            println("NO")
        }
    }
    println(maxRepeat)
}