package main.javaLang.easy.q1636;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SolutionA {
    public int[] frequencySort(int[] nums) {
        // Count frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Custom comparator to sort by frequency (ascending)
        // If frequencies are equal, sort by value (descending)
        Comparator<Integer> customComparator = (a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);

            if (freqA == freqB) {
                return Integer.compare(b, a); // Descending order for values
                // don't return return b-a to avoid overflow
            }
            return Integer.compare(freqA, freqB); // Ascending order for frequencies
            // don't return return a - b to avoid overflow
        };

        // Convert to Integer array to use with custom comparator
        Integer[] boxedNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            boxedNums[i] = nums[i];
        }

        // Sort using custom comparator
        Arrays.sort(boxedNums, customComparator);

        // Convert back to int array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = boxedNums[i];
        }

        return nums;
    }
}
