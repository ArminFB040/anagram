package com.wordplay.anagram.api;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/anagram")
public class AnagramController {

    private final AnagramService anagramService;

    public AnagramController(AnagramService anagramService) {
        this.anagramService = anagramService;
    }

    @PostMapping("/check")
    public boolean checkAnagram(@RequestParam String text1, @RequestParam String text2) {
        return anagramService.areAnagrams(text1, text2);
    }

    @PostMapping("/findAll")
    public List<String> findAllAnagrams(@RequestParam String text, @RequestBody List<String> texts) {
        return anagramService.findAllAnagrams(text, texts);
    }
}
