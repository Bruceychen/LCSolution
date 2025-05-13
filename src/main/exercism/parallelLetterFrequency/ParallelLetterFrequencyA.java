package main.exercism.parallelLetterFrequency;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
class ParallelLetterFrequency {
    private List<String> texts;
    ParallelLetterFrequency(String[] texts) {}
}
*/
public class ParallelLetterFrequencyA {
    private final String[] texts;


    public ParallelLetterFrequencyA(String[] texts) {
        this.texts = texts;
    }


    public Map<Character, Integer> countLetters() {
        // Handle empty input
        if (texts == null || texts.length == 0) {
            return Collections.emptyMap();
        }


        // For single text, process sequentially
        if (texts.length == 1) {
            return countLettersInText(texts[0]);
        }


        // For multiple texts, use parallel processing
        int processors = Runtime.getRuntime().availableProcessors();
        int threadCount = Math.min(processors, texts.length);

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(texts.length);

        ConcurrentHashMap<Character, Integer> totalCounts = new ConcurrentHashMap<>();


        // Create tasks for each text
        for (String text : texts) {
            executor.submit(() -> {
                try {
                    Map<Character, Integer> counts = countLettersInText(text);
                    // Merge counts into the total counts
                    counts.forEach((character, count) -> totalCounts.merge(character, count, Integer::sum));
                } finally {
                    latch.countDown();
                }
            });
        }


        try {
            latch.await(); // Wait for all processing to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            executor.shutdown();
        }


        return totalCounts;
    }


    private Map<Character, Integer> countLettersInText(String text) {
        Map<Character, Integer> counts = new HashMap<>();


        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char lowerChar = Character.toLowerCase(c);
                counts.merge(lowerChar, 1, Integer::sum);
            }
        }


        return counts;
    }
}



