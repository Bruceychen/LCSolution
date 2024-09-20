package javaLang.medium.q347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    //Input: nums = [1,1,1,2,2,3], k = 2
    //Output: [1,2]
    public static int[] topKFrequent(int[] nums, int k) {
        int sizes = nums.length;
        Map<Integer,List<Integer>> countMapToList = new HashMap<>();
        Map<Integer,Integer> countMap = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();

        for(int i : nums){
            if(countMap.containsKey(i)){
                countMap.put(i,countMap.get(i)+1);
            }else{
                countMap.put(i,1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            List temp = countMapToList.get(entry.getValue());
            if(temp==null){
                temp = new ArrayList<>();
            }
            temp.add(entry.getKey());
            countMapToList.put(entry.getValue(),temp);
        }
        for(int i=sizes; i>0;i--){
            List temp =countMapToList.get(i);
            if(k==0) break;
            if(!(temp ==null) && !(temp.isEmpty())){
                resultList.addAll(temp);
                k--;
            }
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();


    }

    public static void main(String[] args) {
        int[] input = {4,1,-1,2,-1,2,3};
        int[] result = topKFrequent(input,2);
        System.out.println(result);
    }
}