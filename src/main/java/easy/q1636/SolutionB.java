package easy.q1636;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class SolutionB {
    public int[] frequencySort(int[] nums) {
        // Count frequency of each number using streams
        Map<Integer, Long> frequencyMap =
                Arrays.stream(nums)
                        .boxed()
                        .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        // Convert to boxed array and apply sorting using a Comparator
        return Arrays.stream(nums)
                .boxed()
//                .sorted((a, b) -> compareByFrequencyThenValue(a, b, frequencyMap))
                .sorted(compareByFrequencyThenValue(frequencyMap))
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // legacy-style comparison method (not used anymore)
    private int compareByFrequencyThenValue(Integer a, Integer b, Map<Integer, Long> frequencyMap) {
        // Compare by frequency (ascending)
        int freqCompare = frequencyMap.get(a).compareTo(frequencyMap.get(b));

        // If frequencies are equal, compare by value (descending)
        if (freqCompare == 0) {
            return Integer.compare(b, a);
        }

        return freqCompare;
    }

    private Comparator<Integer> compareByFrequencyThenValue(Map<Integer, Long> frequencyMap) {
        return (a, b) -> {
            Long fra = frequencyMap.get(a);
            Long frb = frequencyMap.get(b);

            if (fra.equals(frb)) return Integer.compare(b, a);

            return Long.compare(fra, frb);
        };
    }
}
