package com.rox.adventofcode.y2022

import com.rox.adventofcode.puzzleInputFromFile
import java.util.*

private val inputSample = """
${'$'} cd /
${'$'} ls
dir a
14848514 b.txt
8504156 c.dat
dir d
${'$'} cd a
${'$'} ls
dir e
29116 f
2557 g
62596 h.lst
${'$'} cd e
${'$'} ls
584 i
${'$'} cd ..
${'$'} cd ..
${'$'} cd d
${'$'} ls
4060174 j
8033020 d.log
5626152 d.ext
7214296 k
""".trimIndent()

fun main() {
    //println("Sample Input A: ${solutionA(inputSample)}")
    //println("Sample Input B: ${solutionB(inputSample)}")
    println("Part A: ${solutionA(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2022/Day7.input"))}")
    //println("Part B: ${com.rox.adventofcode.y2021.solutionB(puzzleInputFromFile("src/main/kotlin/com/rox/adventofcode/y2021/DayX.input"))}")
}

/**
 *
 *
 * Answer: 196781 is too low
 */
private fun solutionA(input: String): Any {
    val rows = input.split('\n')

    var fileSystem = parseFileSystem(rows)

    val recursiveDirectoryListing = extractDirectories(fileSystem)
    printDirectoryStructure(fileSystem)

   //TODO find all of the directories with a total size of at most 100000, then calculate the sum of their total sizes.
    return recursiveDirectoryListing.map { dir -> dir.size() }.filter { size -> size <= 100000 }.sum()
}

fun printDirectoryStructure(filesystem: Directory, nest: String = ""){
    println("$nest(+) ${filesystem.name()} (${filesystem.size()})")
    filesystem.children.filter { !it.isLeaf() }.forEach { printDirectoryStructure(it as Directory, "$nest\t") }
    filesystem.children.filter { it.isLeaf() }.forEach { child -> println("$nest\t(-) ${child.name()} (${child.size()})") }
}

fun extractDirectories(directory: Directory): Set<Directory> {
    if (directory.children.none { child -> !child.isLeaf() })
        return setOf()

    return directory.children
        .filter { child -> !child.isLeaf() }
        .map { dir ->
            val directory = dir as Directory
            val dirs = mutableSetOf(directory)
            dirs.addAll(extractDirectories(directory))
            dirs
        }
        .flatten()
        .toSet()
}

private fun parseFileSystem(rows: List<String>): Directory {
    var fileSystem = Directory("/")
    var pwd = fileSystem

    val pwdStack = LinkedList<Directory>(listOf(fileSystem))

    rows.forEach { row ->
        when (row[0]) {
            //Command
            '$' -> when {
                //Change directory
                row.slice(2 until row.length).startsWith("cd") -> {
                    when {
                        //Top of file system
                        row.slice(5 until row.length).startsWith("/") -> {
                            //No action, this is bootstrapped
                        }

                        //backup
                        row.slice(5 until row.length).startsWith("..") -> {
                            pwdStack.pop()
                            pwd = pwdStack.last
                        }

                        //directory
                        else -> {
                            val name = row.slice(5 until row.length)
                            val tmp = pwd
                            if (tmp.children.map { c -> c.name() }.contains(name)) {
                                //XXX No type checking here
                                pwd = tmp.children.filter { c -> c.name() == name }.first() as Directory
                                pwdStack.push(pwd)
                            } else {
                                pwd = Directory(name)
                                pwdStack.push(pwd)
                            }
                        }
                    }
                }

                //List director
                row.slice(2 until row.length).startsWith("ls") -> {
                    //Do nothing and just assume the next few lines are files and directories
                }
            }

            //Directory Listing
            'd' -> {
                val name = row.slice(4 until row.length)
                if (!pwd.children.map { c -> c.name() }.contains(name)) {
                    pwd.addChild(Directory(name))
                }
            }

            //File Listing
            in '0'..'9' -> {
                val parts = row.split(" ")
                val size = Integer.parseInt(parts[0]).toLong()
                val name = parts[1]
                if (!pwd.children.map { c -> c.name() }.contains(name)) {
                    pwd.addChild(File(name, size))
                }
            }
        }
    }
    return fileSystem
}

interface Node {
    fun size(): Long
    fun name(): String
    fun isLeaf(): Boolean
}

class Directory(val name: String) : Node {
    val children = mutableListOf<Node>()

    fun addChild(child: Node){
        children.add(child)
    }

    override fun size(): Long {
        return children.map { child -> child.size() }.sum()
    }

    override fun name(): String {
        return name
    }

    override fun isLeaf(): Boolean {
        return false
    }
}

class File(val name: String, val size: Long): Node {
    override fun size(): Long {
        return size
    }

    override fun name(): String {
        return name
    }

    override fun isLeaf(): Boolean {
        return true
    }
}

/**
 *
 * Answer: ???
 */
private fun solutionB(input: String): Any {
    val rows = input.split('\n')

    return input
}

