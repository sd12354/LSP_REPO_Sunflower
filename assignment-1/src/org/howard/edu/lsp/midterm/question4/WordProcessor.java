package org.howard.edu.lsp.midterm.question4;

import java.util.*;

public class WordProcessor {
    private String sentence; // Sentence to be processed

    /**
     * @param sentence The input sentence to process.
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds all longest words in the sentence.
     * @return A list of the longest words in order of appearance.
     */
    public List<String> findLongestWords() {
        if (sentence == null || sentence.trim().isEmpty()) {
            return Collections.emptyList(); // Return empty list if input is empty or null
        }
        
        String[] words = sentence.split("\\s+"); // Split sentence into words
        List<String> longestWords = new ArrayList<>();
        int maxLength = 0;
        
        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
                longestWords.clear(); // Clears previous words if a longer word is found
            }
            if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }
        return Collections.unmodifiableList(longestWords); // Return an unmodifiable list for safety
    }
}
