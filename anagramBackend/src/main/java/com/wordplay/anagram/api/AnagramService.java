package com.wordplay.anagram.api;

import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnagramService {

    // Überprüft, ob zwei Strings Anagramme sind
    public boolean areAnagrams(String text1, String text2) {
        // Null- oder leere Strings abfangen
        if (text1 == null || text2 == null || text1.isEmpty() || text2.isEmpty()) {
            return false;
        }

        // Strings normalisieren und sortieren
        return sortString(normalizeText(text1)).equals(sortString(normalizeText(text2)));
    }

    // Findet alle Anagramme eines gegebenen Strings in einer Liste von Strings
    public List<String> findAllAnagrams(String text, List<String> texts) {
        List<String> anagrams = new ArrayList<>();

        // Null- oder leere Eingabe abfangen
        if (text == null || text.isEmpty() || texts == null || texts.isEmpty()) {
            return anagrams;
        }

        // Den Zielstring normalisieren und sortieren
        String sortedText = sortString(normalizeText(text));

        // Überprüfen und Anagramme sammeln
        for (String t : texts) {
            if (t != null && !t.isEmpty() && sortedText.equals(sortString(normalizeText(t)))) {
                anagrams.add(t);
            }
        }

        return anagrams;
    }

    // Normalisiert den Text, entfernt nicht alphabetische Zeichen und konvertiert zu Kleinbuchstaben
    private String normalizeText(String text) {
        text = text.toLowerCase().replaceAll("[^a-z]", ""); // Nur alphabetische Zeichen beibehalten
        text = Normalizer.normalize(text, Normalizer.Form.NFD); // Normalisieren (z.B. ä -> a + ¨)
        return text.replaceAll("[\\p{InCombiningDiacriticalMarks}]", ""); // Diakritische Zeichen entfernen
    }

    // Sortiert die Zeichen eines Strings
    private String sortString(String text) {
        char[] chars = text.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
