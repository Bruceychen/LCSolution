package javaLang.medium.q238;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        String[] sortArray = new String[nums.length + 1];
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }
        countMap.forEach((key, value) -> {
            if (sortArray[value] == null || sortArray[value].isEmpty()) {
                sortArray[value] = String.valueOf(key);
            } else {
                sortArray[value] = sortArray[value] + "," + key;
            }
        });

        int[] result = new int[0];
        for (int i = sortArray.length - 1; i >= 0; i--) {
            if (sortArray[i] != null && !sortArray[i].isEmpty()) {
                if (k > 0) {
                    k--;
                    int l = result.length;
                    result = Arrays.copyOf(result, result.length + sortArray[i].split(",").length);
                    for (String s : sortArray[i].split(",")) {
                        result[l] = Integer.parseInt(s);
                        l++;
                    }
                } else {
                    return result;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        int k = 1;

        int[] result = topKFrequent(nums, k);

        System.out.println("Result: " + Arrays.toString(result));
    }
}