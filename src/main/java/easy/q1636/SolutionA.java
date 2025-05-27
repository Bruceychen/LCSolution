package main.javaLang.easy.q1636;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
// without lambda/stream api
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
        Comparator<Integer> customComparator = this.customComparator(frequencyMap);

        // Sort using custom comparator
        // since its an object array but not a List/Collection, can only use Arrays
        Arrays.sort(boxedNums, customComparator);

        // Convert back to int array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = boxedNums[i];
        }

        return nums;
    }

    private Comparator<Integer> customComparator(final Map<Integer, Integer> frequencyMap) {
        return new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                Integer fra = frequencyMap.get(a);
                Integer frb = frequencyMap.get(b);

                if (fra.equals(frb)) return Integer.compare(b, a);
                return Integer.compare(fra, frb);
            }
        };
    }

}
