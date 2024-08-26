package com.wordplay.anagram.api;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnagramServiceTest {

    private final AnagramService anagramService = new AnagramService();

    @Test
    void testAreAnagramsWithValidAnagrams() {
        assertTrue(anagramService.areAnagrams("listen", "silent"));
        assertTrue(anagramService.areAnagrams("Triangle", "Integral"));
        assertTrue(anagramService.areAnagrams("The eyes", "They see"));
    }

    @Test
    void testAreAnagramsWithNonAnagrams() {
        assertFalse(anagramService.areAnagrams("hello", "world"));
        assertFalse(anagramService.areAnagrams("abc", "abcd"));
        assertFalse(anagramService.areAnagrams("abc", "def"));
    }

    @Test
    void testAreAnagramsWithDifferentCases() {
        assertTrue(anagramService.areAnagrams("Listen", "Silent"));
        assertTrue(anagramService.areAnagrams("Triangle", "Integral"));
        assertTrue(anagramService.areAnagrams("Debit Card", "Bad Credit"));
    }

    @Test
    void testAreAnagramsWithSpecialCharacters() {
        assertTrue(anagramService.areAnagrams("a+b=c", "c=b+a"));
        assertTrue(anagramService.areAnagrams("Astronomer", "Moon starer!"));
        assertTrue(anagramService.areAnagrams("Dormitory", "Dirty room!!!"));
    }

    @Test
    void testAreAnagramsWithNullOrEmptyStrings() {
        assertFalse(anagramService.areAnagrams(null, "silent"));
        assertFalse(anagramService.areAnagrams("listen", null));
        assertFalse(anagramService.areAnagrams("", "silent"));
        assertFalse(anagramService.areAnagrams("listen", ""));
        assertFalse(anagramService.areAnagrams("", ""));
        assertFalse(anagramService.areAnagrams(null, null));
    }

    @Test
    void testFindAllAnagramsWithValidAnagrams() {
        List<String> candidates = Arrays.asList("enlist", "google", "inlets", "banana", "silent");
        List<String> expected = Arrays.asList("enlist", "inlets", "silent");
        List<String> result = anagramService.findAllAnagrams("listen", candidates);
        assertEquals(expected, result);
    }

    @Test
    void testFindAllAnagramsWithNoAnagrams() {
        List<String> candidates = Arrays.asList("hello", "world", "java", "spring");
        List<String> result = anagramService.findAllAnagrams("listen", candidates);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFindAllAnagramsWithMixedCase() {
        List<String> candidates = Arrays.asList("Enlist", "Google", "Inlets", "Banana", "Silent");
        List<String> expected = Arrays.asList("Enlist", "Inlets", "Silent");
        List<String> result = anagramService.findAllAnagrams("Listen", candidates);
        assertEquals(expected, result);
    }

    @Test
    void testFindAllAnagramsWithSpecialCharacters() {
        List<String> candidates = Arrays.asList("moon starer!", "Room dirty", "car race", "Dormitory");
        List<String> expected = Arrays.asList("moon starer!");
        List<String> result = anagramService.findAllAnagrams("Astronomer", candidates);
        assertEquals(expected, result);
    }

    @Test
    void testFindAllAnagramsWithEmptyOrNullInputs() {
        assertTrue(anagramService.findAllAnagrams(null, Collections.emptyList()).isEmpty());
        assertTrue(anagramService.findAllAnagrams("", Collections.emptyList()).isEmpty());
        assertTrue(anagramService.findAllAnagrams("listen", null).isEmpty());
        assertTrue(anagramService.findAllAnagrams("listen", Collections.emptyList()).isEmpty());
        assertTrue(anagramService.findAllAnagrams("", Arrays.asList("silent", "enlist")).isEmpty());
    }
}
