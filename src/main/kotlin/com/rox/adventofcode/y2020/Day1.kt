package com.rox.adventofcode.y2020

import java.rmi.UnexpectedException

private val inputA = """
997
1582
1790
1798
1094
1831
1879
1730
1995
1702
1680
1869
1964
1777
1862
1928
1997
1741
1604
1691
1219
1458
1749
1717
1786
1665
1724
1998
1589
1828
1953
1848
1500
1590
1968
1948
1323
1800
1986
679
1907
1916
1820
1661
1479
1808
1824
1825
1952
1666
1541
1791
1906
1638
1557
1999
1710
1549
1912
1974
1628
1748
1411
1978
1865
1932
1839
1892
1981
1807
357
912
1443
1972
1816
1890
1029
1175
1522
1750
2001
1655
1955
1949
1660
233
1891
1994
1934
1908
1573
1712
1622
1770
1574
1778
1851
2004
1818
1200
1229
1110
1005
1716
1765
1835
1773
15
1914
1833
1689
1843
1718
1872
390
1941
1178
1670
1899
1864
1913
2010
1855
1797
1767
1673
1657
1607
1305
1341
1662
1845
1980
1534
1789
1876
1849
1926
1958
977
1709
1647
1832
1785
1854
1667
1679
1970
1186
2000
1681
1684
1614
1988
1561
1594
1636
1327
1696
1915
1045
1829
1079
1295
1213
1714
1992
1984
1951
1687
1842
1792
87
1732
428
1799
1850
1962
1629
1965
1142
1040
131
1844
1454
1779
1369
1960
1887
1725
1893
1465
1676
1826
1462
1408
1937
1643
1069
1759
""".trimIndent()

fun main() {
    println("Part A: ${solutionA(inputA)}")
    println("Part B: ${solutionB(inputA)}")
}

/**
 * --- Day 1: Report Repair ---
 * After saving Christmas five years in a row, you've decided to take a vacation at a nice resort
 * on a tropical island. Surely, Christmas will go on without you.
 *
 * The tropical island has its own currency and is entirely cash-only. The gold coins used there
 * have a little picture of a starfish; the locals just call them stars. None of the currency
 * exchanges seem to have heard of them, but somehow, you'll need to find fifty of these coins
 * by the time you arrive so you can pay the deposit on your room.
 *
 * To save your vacation, you need to get all fifty stars by December 25th.
 *
 * Collect stars by solving puzzles. Two puzzles will be made available on each day in the
 * Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants
 * one star. Good luck!
 *
 * Before you leave, the Elves in accounting just need you to fix your expense report (your
 * puzzle input); apparently, something isn't quite adding up.
 *
 * Specifically, they need you to find the two entries that sum to 2020 and then multiply those
 * two numbers together.
 *
 * For example, suppose your expense report contained the following:
 *
 * 1721
 * 979
 * 366
 * 299
 * 675
 * 1456
 * In this list, the two entries that sum to 2020 are 1721 and 299. Multiplying them together
 * produces 1721 * 299 = 514579, so the correct answer is 514579.
 *
 * Of course, your expense report is much larger. Find the two entries that sum to 2020; what
 * do you get if you multiply them together?
 *
 * Answer: 910539
 */
private fun solutionA(input: String): Any {
    //Assume there are only two numbers which sum to 2020
    val numbers = input.split('\n').map { it.toInt() }.distinct()
    for (x in numbers) for (y in numbers){
        if (2020 == x+y){
            return x*y
        }
    }

    throw UnexpectedException("There seems to be no two numbers which can be added to 2020 as expected")
}

/**
 * --- Part Two ---
 * The Elves in accounting are thankful for your help; one of them even offers you a starfish
 * coin they had left over from a past vacation. They offer you a second one if you can find
 * three numbers in your expense report that meet the same criteria.
 *
 * Using the above example again, the three entries that sum to 2020 are 979, 366, and 675.
 * Multiplying them together produces the answer, 241861950.
 *
 * In your expense report, what is the product of the three entries that sum to 2020?
 *
 * WRONG: 116724144
 */
private fun solutionB(input: String): Any {
    //Assume there are only three numbers which sum to 2020
    val numbers = input.split('\n').map { it.toInt() }.distinct()
    for (x in numbers) for (y in numbers) for (z in numbers){
        if (2020 == x + y + z) {
            return x * y * z
        }
    }

    throw UnexpectedException("There seems to be no three numbers which can be added to 2020 as expected")
}


