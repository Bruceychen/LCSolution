package main.javaLang.easy.q1636;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SolutionA {
    public int[] frequencySort(int[] nums) {
        // Count frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // new Array to carry boxed number for later sorting
        Integer[] boxedNums = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
            boxedNums[i] = nums[i];
        }

        // Custom comparator to sort by frequency (ascending)
        // If frequencies are equal, sort by value (descending)
        Comparator<Integer> customComparator = (a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);

            // return b, a because we want to sort in descending order
            if (freqA == freqB)
                return Integer.compare(b, a); // don't return return b - a to avoid overflow

            return Integer.compare(freqA, freqB); // don't return return a - b to avoid overflow
        };


        // Sort using custom comparator
        Arrays.sort(boxedNums, customComparator);

        // Convert back to int array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = boxedNums[i];
        }

        return nums;
    }
}
