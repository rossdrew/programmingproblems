package com.rox.adventofcode.y2018

private val inputA = """
lsrivfotzgdxpkefaqmuiygchj
lsrivfotzqdxpkeraqmewygchj
lsrivfotzbdepkenarjuwygchj
lsrivfotwbdxpkeoaqmunygchj
lsrijfotzbdxpkenwqmuyygchj
lsrivfotzbdxpkensqsuwygcdj
lsrivfotubdxpkenzqmuwyschj
lsrjvwotzbdxpkenaqjuwygchj
lsrtvfotzbdxpkeaaqmuqygchj
lscivzotzbdxpkenaqmuwygcnj
ddrivfotzbdxpkenlqmuwygchj
jsrivfvtzbdxpkenaqmufygchj
csrivfotzxdxpkenaqguwygchj
lprivfbtzbqxpkenaqmuwygchj
lsrnvfotzbnxpkenaqmuwygchk
lsiivfotzbdhpkencqmuwygchj
lsrivfotzbyxpkenaqmzwygchc
lsjivfotqbdxpvenaqmuwygchj
lsrivfotzbdxpkencqmuwvgqhj
lsrivfotzhdxpqenaqouwygchj
lsrivfytzbnxpkenaqmuwygcsj
llrivfotzbdxpkenaqmuwynchd
lsuivfotzbdxpnenaqmuwygchk
lsrtvootnbdxpkenaqmuwygchj
ysrivfotzcdxpkenaqmuwhgchj
lsrivfotxbdxpkefgqmuwygchj
lsrmvfotzbaxpkenaqmuwygfhj
lsrivfothbyxpkxnaqmuwygchj
isrivfotzbdxpkenaqmkwygcht
lhrivfotzbdxpkbnfqmuwygchj
lsrivfotzbmxpkenaqmuwbgdhj
lsrivvotzbdxcoenaqmuwygchj
ssrwvfotzbdjpkenaqmuwygchj
lsrivfotgbwxpkenaqmhwygchj
lsrivfotzbdxpkenaqcuhygcyj
lcdivfotzbdxpkenaqmuwxgchj
ysbivfotzbdxpkenaqmuwkgchj
lsrivfltzbdxxkenaqcuwygchj
lsrivfotzbdxpkgnaqmunegchj
fsqpvfotzbdxpkenaqmuwygchj
lsriifotzbcxpkenaqmubygchj
lsrivfotzjdxpkenaqmugygcjj
tsrikfotzbdxpkeneqmuwygchj
larivfotzbdxpkenaqmwwygcpj
larivfotzbdxpkenaqmuayrchj
lsravfotzbdxpkdoaqmuwygchj
lsrivfotzbixpkenaqvtwygchj
lsrixfotnbdxtkenaqmuwygchj
lsrirfotzbdxpkeneqmuwygchv
lsrivfofzedxpkenaqmswygchj
lwrivfotzvdxpkenaqmuwygfhj
lsrivfotzbdapkenaqmuqygehj
lsrizfotgbdxpkenaqjuwygchj
lsrivioxzbdxpkanaqmuwygchj
lsrivfmtzbdxpkgnaqmuwcgchj
lsrivfotzbdxpkeaaqmuofgchj
lsrivfotvbdxpkenuqmuwygcht
lsrivfothcdxpkenaqouwygchj
lsgivfotzbdxpkenawmuwygchi
lsrigfotzbdxpmonaqmuwygchj
lsrivfotzbdxrkfnaqmuwygcha
lsrivfopobdxpkenaqmuwygchv
lsrejfotzbdxpkvnaqmuwygchj
lsrivfotzbdxplenqqmuwygchz
lsmivfotzbdppkebaqmuwygchj
lsrivfotubdipkewaqmuwygchj
lsrivfodnbhxpkenaqmuwygchj
lsrivfotzbdxpkenaqmkwzgshj
lsrixfotzbdxpkensqmuwygohj
lsdivfotzbdxpkenaqmuwagcwj
lsrimfotzbdxpkenaqmuwygcyu
asnivfotzbdxpkenaqmbwygchj
lseivfltfbdxpkenaqmuwygchj
lsrivfbtzbdxpuenaqmuwyychj
lsziafozzbdxpkenaqmuwygchj
lsrivfotzbdxpkwnaomuwygchg
ldrivfotzbdxpkeniqmuwygihj
lsrivfotzbdxpkenaqhdwycchj
lsrigfotzbdxphenaqmuwynchj
lsripfotzbdxpgenaqmuwygchh
lsrgvfoczbdxpkenaqmuwygihj
lsribfotzbgxpkenaqhuwygchj
lsrkvfotztdxpienaqmuwygchj
lsrivfohzbdxpkenaqrxwygchj
lsrivfoszbdxpkenavmuwygvhj
lsrivfstzblxpkcnaqmuwygchj
lzrivfotzbdxpkegaqmuwygchv
lsrivtotzbdxpkenaqrumygchj
lsgivfotzbdwpkenaqmuwhgchj
lurivfotybdxpkenaqmuwygchg
lsrivfogzbdxpkmnrqmuwygchj
lsrivgotzbdxpkengqmuwygcwj
lirivfbyzbdxpkenaqmuwygchj
lwrivfotzbdxpkbjaqmuwygchj
lsrivkotzbqxakenaqmuwygchj
lxrivfotzbdxpkenaqmuwygshy
lxxivfqtzbdxpkenaqmuwygchj
lsrivfohzbdxpzenaqmuzygchj
lsrivfotzndxekenaqmuwygcvj
lsrdvfotzbdxpkenaqguiygchj
lsrivfotzbdxpiehaqauwygchj
atrivfotzbdxpkenaqmuwygchz
lsrivfovzbdxpkenaqmuvygcwj
lsrivfotzmdxpkennqmuwyxchj
luvcvfotzbdxpkenaqmuwygchj
lsriqfotzbdxpbenaqmuwygchg
bsoivfotzudxpkenaqmuwygchj
lsrivfotzbdxphenaqmhwxgchj
lsrivfotzbdxpkenasmuwjgchw
lsrivdotzboxpkenaqmuwykchj
lsqivfotzbdxcdenaqmuwygchj
lsrivfktzndypkenaqmuwygchj
lwrivfotzbdxpkenaqmuolgchj
lkrivfowzbdxpkenaqmbwygchj
lsrivhotzbdxpkenaqyuwygvhj
lsruvfotzbdxpkecaqmukygchj
lsrivdotzbdsskenaqmuwygchj
lsrivfotzbdxpkanaqmuwygcmc
lsrgvfotubdxpkenrqmuwygchj
psrivfotzbdxpkenaqmutygchd
lsrivfitzbdxpkenagmiwygchj
lsrivfotzbdxpkbnaqauwyrchj
lsrivfotvbdxpjenaqmuwygchr
lsrdvfoyzbjxpkenaqmuwygchj
vsrivfothbdxpkenaqmuwyychj
lyrivfotzpdxpkepaqmuwygchj
lsgbqfotzbdxpkenaqmuwygchj
lxrivfotzbdxpkenegmuwygchj
lsrivfokzbdxpkenaqnuwyxchj
lsrivfotubmxpkexaqmuwygchj
lswivfvtzbdxpkenaqmuwygcgj
lsrivfonzbdxpkenaqiuwygchc
isrivlotzbdxpkenaqmuwygchf
lsrilfozzbdxpkenaqmuwygcvj
wsrivfotzbdxpkepaqmuwegchj
lsrivfrtzbrxpkenaqquwygchj
lsrivfotzbdxpkeqaqmuoygjhj
lsrivfotzmdxpkenaqmuwyxchg
lsrnvfotzbzxxkenaqmuwygchj
ldrivfotzbdxpkenaqmlxygchj
lsriofotzbdxpkenaqmwwmgchj
lsrivfotzodxjkenaqmuwyglhj
lsriviotzbdxpkegaqguwygchj
lsrimfotzbdxpkanaqmuwygshj
lwrzvfotzbdxpkenaqmuwygcfj
lirivfotzbdxkkenvqmuwygchj
lsrivfotlbdxpkeoaqmuwygahj
lsxivfotzbdxpkenaqmuwwgchi
lsrivfotzbdxpkenaqmukygzzj
lsrtvfotzbdxskenaqmuwygcij
lsgilfotzbdxpdenaqmuwygchj
lsriyfotbbdxpkenaqmuwygchm
lsrivfotabdxpkenaqmuwyghhs
xsrizfotzbdxpkenaqmuwygczj
lsrivfotybdxpkenaqquwygchx
lsrzvfofzbdxpktnaqmuwygchj
xsripfotzbdxpkenaqmqwygchj
lsrivfotzbdspkenahmuwugchj
lsmivfotzbdbpkenaqmuwygchy
lsruvfotzbdxpkenaqqpwygchj
lrmivfotzbdxpkenaqguwygchj
lsnivfotzbdlpketaqmuwygchj
lsrivfotzbdxjketaqjuwygchj
lsrivxotzbdchkenaqmuwygchj
lsrivootzbdxpkenaqmuwybmhj
tsrivfdtzbdxpkenaqmuwpgchj
lsrivmotzbdxpkxnaqmuwcgchj
lsrivfotzadepkenaqmuwyichj
dsrivfotrbdxpkenaqmuwtgchj
lsrivfhtzbdxvkenoqmuwygchj
lsrivfotzvdxbkenaqmbwygchj
lsrxvcotzbdxpkenaqmuwygvhj
lsrivfotzbdxykenaqmuwfgcha
lsbivfotzbdxpkenaqmuwfvchj
lfrivfotzbdcpkgnaqmuwygchj
lsrivfotzbdxpwegdqmuwygchj
lsrivfotyjdupkenaqmuwygchj
gsrivfotzbdxpkenaemuwcgchj
lsrivfodqbdxpkenaqmuwygchg
lsrivfoczbdxpkenaqnuwwgchj
lsrivpouzbhxpkenaqmuwygchj
llbivuotzbdxpkenaqmuwygchj
lfrivfofzbdxpkenaqmuwygchb
lsrivfotzbdxpkenaumuwgghhj
lsrivfotzbdxqaenazmuwygchj
lsrivfotzbgxpkenkqmqwygchj
lsrivfotzbdxpkensqiawygchj
ljrijfotzbdxppenaqmuwygchj
lsrivfoszbdxpkrnlqmuwygchj
lsrijfotzbdxpcfnaqmuwygchj
lsrivfotzbdopkebaqmuwytchj
lsrivfonzbdxnkenalmuwygchj
larivfouzbvxpkenaqmuwygchj
lsryvfotzbdxpkensqmuwygyhj
lsrivfztzbdxpkenaxmuwigchj
lqkivfotzbdxpkenaqmuwygcht
wsdivfotzbdxpkenbqmuwygchj
lsrlvfotzadxpkencqmuwygchj
lsrivfotoohxpkenaqmuwygchj
lsrivfbuzbdfpkenaqmuwygchj
psrivfotzbdxpkenawmuqygchj
lsrivmotzbdxpkxnaqmuwcychj
lsrivfotzvdgpkenaqmuwlgchj
lcfivfstzbdxpkenaqmuwygchj
lsrivfotzbddpkeeaqmuwygcij
lsribfotzbdxpkenaqmuwugcyj
lsrivfotzbdxakenaqmkwygyhj
lsrivfotzbdxpkegaqmupyvchj
lfrivfitzbdxpkenaqmuwygcrj
lskivfotzbdxpkenaqmuwygwwj
lsrivfotzddnpkenaqmuwfgchj
lsrivfotzbdiukhnaqmuwygchj
lfrivfotzbdxpkendqmuwygctj
ljriqfotzvdxpkenaqmuwygchj
lsrivfotzbdxpkeskqpuwygchj
lsrivfotzbdxpkehaqmupygghj
lsriyfotsbdxpkedaqmuwygchj
lsrivfotzbdsjsenaqmuwygchj
lsrivfotzbwxpienaqmuaygchj
lsrivrotzbdxpkenaumuwygahj
lsrivpotzfdxpkenaqmuwyjchj
lsrivfomebdxpoenaqmuwygchj
lswigfotpbdxpkenaqmuwygchj
lsrivnotzbdxpkenaqmufrgchj
lsrivfolbbdxpkenaqmuwygcqj
lirivfotzbdxpknnaqeuwygchj
lsrrvfxtzbdxpaenaqmuwygchj
lspivfotzbdxpnsnaqmuwygchj
lsrivfotzbyxpkenaqmawygcij
lsrivfotzbfxpbenaqmuwyichj
lsrivfotzbvxpjeyaqmuwygchj
lyrihfotzbdxpknnaqmuwygchj
uurivfotzbdxpkenaqmubygchj
lsrivfotgbdxnkenaxmuwygchj
lsriffotzbdxpkdnaqmuwygshj
lsrisfotzbdxpkenaqzjwygchj
lsrilfotzbdxpkenaqmuwygtgj
lsrivfotzbdxzkenaqmuhmgchj
hsrivfotzbdxprenaqauwygchj
tsrevfotzbdupkenaqmuwygchj
lsrizfotzbpxpkenaqmuwyrchj
lsdivfotzbxxpkenaqmuhygchj
lsrivfttzbyxpkenaqmuaygchj
lsrivfotzodxpwenaqzuwygchj
lsrivfotfbdxpkenaqvuwygyhj
lsrivfotzzdxpknnaqmulygchj
lsrjvvotzbdxpkenaqmuwjgchj
lsrivuotzbdxpkeiaqxuwygchj
lsrivfotzbdxpzenaqmmwygthj
lsrivfotzbdxphenaqmuwyghvj
""".trimIndent()

fun main(args: Array<String>) {
    println("Part A: ${solutionA(inputA)}")
    println("Part B: ${solutionB(inputA)}")
}

/**
 * --- Day 2: Inventory Management System ---
 *
 * You stop falling through time, catch your breath, and check the screen on the device. "Destination reached. Current
 * Year: 1518. Current Location: North Pole Utility Closet 83N10." You made it! Now, to find those anomalies.
 *
 * Outside the utility closet, you hear footsteps and a voice. "...I'm not sure either. But now that so many people have
 * chimneys, maybe he could sneak in that way?" Another voice responds, "Actually, we've been working on a new kind of
 * suit that would let him fit through tight spaces like that. But, I heard that a few days ago, they lost the prototype
 * fabric, the design plans, everything! Nobody on the team can even seem to remember important details of the project!"
 *
 * "Wouldn't they have had enough fabric to fill several boxes in the warehouse? They'd be stored together, so the box
 * IDs should be similar. Too bad it would take forever to search the warehouse for two similar box IDs..." They walk
 * too far away to hear any more.
 *
 * Late at night, you sneak to the warehouse - who knows what kinds of paradoxes you could cause if you were
 * discovered - and use your fancy wrist device to quickly scan every box and produce a list of the likely candidates
 * (your puzzle input).
 *
 * To make sure you didn't miss any, you scan the likely candidate boxes again, counting the number that have an ID
 * containing exactly two of any letter and then separately counting those with exactly three of any letter. You can
 * multiply those two counts together to get a rudimentary checksum and compare it to what your device predicts.
 *
 * For example, if you see the following box IDs:
 *
 * abcdef contains no letters that appear exactly two or three times.
 * bababc contains two a and three b, so it counts for both.
 * abbcde contains two b, but no letter appears exactly three times.
 * abcccd contains three c, but no letter appears exactly two times.
 * aabcdd contains two a and two d, but it only counts once.
 * abcdee contains two e.
 * ababab contains three a and three b, but it only counts once.
 * Of these box IDs, four of them contain a letter which appears exactly twice, and three of them contain a letter which
 * appears exactly three times. Multiplying these together produces a checksum of 4 * 3 = 12.
 *
 * What is the checksum for your list of box IDs?
 *
 * Answer: 7688
 */
private fun solutionA(input : String) : Any {
    val ids = input.split('\n')

    var triplicates = 0
    var duplicates = 0
    ids.forEach{ id ->
        //Occurrences of duplicate and triplicate values
        val occ = id.groupBy { it }.values
                                   .map { it.size }
                                   .filter { it in 2..3 }
                                   .distinct()

        if (occ.contains(2)) duplicates++
        if (occ.contains(3)) triplicates++
    }

    println("Found $duplicates duplicates and $triplicates triplicates")
    return triplicates * duplicates
}

/**
 * --- Part Two ---
 * Confident that your list of box IDs is complete, you're ready to find the boxes full of prototype fabric.
 *
 * The boxes will have IDs which differ by exactly one character at the same position in both strings. For example,
 * given the following box IDs:
 *
 * abcde
 * fghij
 * klmno
 * pqrst
 * fguij
 * axcye
 * wvxyz
 *
 * The IDs abcde and axcye are close, but they differ by two characters (the second and fourth). However, the IDs fghij
 * and fguij differ by exactly one character, the third (h and u). Those must be the correct boxes.
 *
 * What letters are common between the two correct box IDs? (In the example above, this is found by removing the
 * differing character from either ID, producing fgij.)
 */
private fun solutionB(input : String) : Any {
    val ids = input.split('\n')

    ids.forEach { idA ->
        ids.forEach{ idB ->
            var differences = 0

            for (i in 0 until idA.length){
                if (idA[i] != idB[i])
                    differences++
                if (differences > 1)
                    break
            }

            if (differences == 1) {
                var commonCharacters = ""
                for (i in 0 until idA.length){
                    if (idA[i] == idB[i])
                        commonCharacters += idA[i]
                }

                return commonCharacters
            }
        }
    }

    return ""
}


