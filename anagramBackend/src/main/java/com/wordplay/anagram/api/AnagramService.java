package com.wordplay.anagram.api;

import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Service class for handling anagram-related operations.
 */
@Service
public class AnagramService {

    /**
     * Checks if two strings are anagrams of each other.
     *
     * @param text1 The first string to compare.
     * @param text2 The second string to compare.
     * @return true if the two strings are anagrams, false otherwise.
     */
    public boolean areAnagrams(String text1, String text2) {
        // Handle null or empty strings
        if (text1 == null || text2 == null || text1.isEmpty() || text2.isEmpty()) {
            return false;
        }

        // Normalize and sort the strings before comparison
        return sortString(normalizeText(text1)).equals(sortString(normalizeText(text2)));
    }

    /**
     * Finds all anagrams of a given string from a list of candidate strings.
     *
     * @param text The base string to find anagrams for.
     * @param texts The list of candidate strings.
     * @return A list of strings from the candidates that are anagrams of the base string.
     */
    public List<String> findAllAnagrams(String text, List<String> texts) {
        List<String> anagrams = new ArrayList<>();

        // Handle null or empty input
        if (text == null || text.isEmpty() || texts == null || texts.isEmpty()) {
            return anagrams;
        }

        // Normalize and sort the base string
        String sortedText = sortString(normalizeText(text));

        // Check each candidate string and collect the anagrams
        for (String t : texts) {
            if (t != null && !t.isEmpty() && sortedText.equals(sortString(normalizeText(t)))) {
                anagrams.add(t);
            }
        }

        return anagrams;
    }

    /**
     * Normalizes a text by removing non-alphabetic characters, converting to lowercase,
     * and removing diacritical marks.
     *
     * @param text The text to normalize.
     * @return The normalized text.
     */
    private String normalizeText(String text) {
        // Convert text to lowercase and remove non-alphabetic characters
        text = text.toLowerCase().replaceAll("[^a-z]", "");

        // Normalize the text to remove diacritical marks
        text = Normalizer.normalize(text, Normalizer.Form.NFD);
        return text.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    }

    /**
     * Sorts the characters in a string.
     *
     * @param text The text to sort.
     * @return A new string with characters sorted in ascending order.
     */
    private String sortString(String text) {
        char[] chars = text.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
