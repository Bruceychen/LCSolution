package main.javaLang.easy.q1636;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class SolutionB {
    public int[] frequencySort(int[] nums) {
        // Count frequency of each number using streams
        Map<Integer, Long> frequencyMap =
                Arrays.stream(nums)
                        .boxed()
                        .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        // Convert to boxed array and apply sorting
        return Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> compareByFrequencyThenValue(a, b, frequencyMap))
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // Standalone comparator method
    private int compareByFrequencyThenValue(Integer a, Integer b, Map<Integer, Long> frequencyMap) {
        // Compare by frequency (ascending)
        int freqCompare = frequencyMap.get(a).compareTo(frequencyMap.get(b));

        // If frequencies are equal, compare by value (descending)
        if (freqCompare == 0) {
            return Integer.compare(b, a);
        }

        return freqCompare;
    }
}