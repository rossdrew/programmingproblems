package com.rox.prob.adventofcode.y2017;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * --- Day 4: High-Entropy Passphrases ---
 *
 * A new system policy has been put in place that requires all accounts to use a passphrase instead of simply a
 * password. A passphrase consists of a series of words (lowercase letters) separated by spaces.
 *
 * To ensure security, a valid passphrase must contain no duplicate words.
 *
 * For example:
 *
 * aa bb cc dd ee is valid.
 * aa bb cc dd aa is not valid - the word aa appears more than once.
 * aa bb cc dd aaa is valid - aa and aaa count as different words.
 * The system's full passphrase list is available as your puzzle input. How many passphrases are valid?
 *
 * --- Part Two ---
 *
 * For added security, yet another system policy has been put in place. Now, a valid passphrase must contain no two
 * words that are anagrams of each other - that is, a passphrase is invalid if any word's letters can be rearranged to
 * form any other word in the passphrase.
 *
 * For example:
 *
 * abcde fghij is a valid passphrase.
 * abcde xyz ecdab is not valid - the letters from the third word can be rearranged to form the first word.
 * a ab abc abd abf abj is a valid passphrase, because all letters need to be used when forming another word.
 * iiii oiii ooii oooi oooo is valid.
 * oiii ioii iioi iiio is not valid - any of these words can be rearranged to form any other word.
 * Under this new system policy, how many passphrases are valid?
 */
public class Day4 {
    /**
     * Does the given passphrase contain two identicle words
     */
    public boolean hasDuplicateWord(String passphrase) {
        final String[] words = passphrase.split("\\s+");
        final Set<String> usedWords = new HashSet<>();

        for (String word : words) {
            if (usedWords.contains(word)) {
                return true;
            }
            usedWords.add(word);
        }

        return false;
    }

    /**
     * Does the given passphrase contain two words that are anagrams of each other
     */
    public boolean hasAnagramPair(String passphrase) {
        final String[] words = passphrase.split("\\s+");
        final Set<String> usedWords = new HashSet<>();

        //Generate dictionary, halt if a duplicate anagram is added
        for (String word : words) {
            String orderedWord = orderString(word);
            System.out.println("Adding '" + word + "' to dictionary as '" + orderedWord + "'");
            if (usedWords.contains(orderedWord))
                return true;
            usedWords.add(orderedWord);
        }

        return false;
    }

    /**
     * Adjust a String to be a new String which contains the old strings characters, in order
     */
    private String orderString(String unorderedString){
        char[] ordered = unorderedString.toCharArray();
        Arrays.sort(ordered);
        return new String(ordered);
    }

    public int part1Solution(final String passphraseList){
        final String[] passphrases = passphraseList.split("\\R");

        int validPassphrases = 0;
        for (String passphrase : passphrases) {
            validPassphrases += hasDuplicateWord(passphrase) ? 0 : 1;
        }

        return validPassphrases;
    }

    public int part2Solution(final String passphraseList){
        final String[] passphrases = passphraseList.split("\\R");

        int validPassphrases = 0;
        for (String passphrase : passphrases) {
            validPassphrases += hasAnagramPair(passphrase) ? 0 : 1;
        }

        return validPassphrases;
    }
}
