package main.exercism.parallelLetterFrequency;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/*
class ParallelLetterFrequency {
    private List<String> texts;
    ParallelLetterFrequency(String[] texts) {}
}
*/

class ParallelLetterFrequencyB {


    private List<String> texts;
    private ConcurrentMap<Character, Integer> innerMap;


    ParallelLetterFrequencyB(String[] texts) {
        //        this.texts = List.of(texts);
        this.texts = arraysToList(texts);
        this.innerMap = new ConcurrentHashMap<>();
    }


    private List<String> arraysToList(String[] texts) {
        List<String> list = new ArrayList<>();
        for (String str : texts) {
            list.add(str);
        }
        return list;
    }


    Map<Character, Integer> countLetters() {
        if (!this.innerMap.isEmpty() || texts.isEmpty()) {
            return this.innerMap;
        }
        texts.parallelStream().forEach(text -> {
            for (char c : text.toLowerCase().toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    innerMap.merge(c, 1, Integer::sum);
                }
            }
        });
        return this.innerMap;
    }
}