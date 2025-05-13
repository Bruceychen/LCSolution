package main.javaLang.easy.q268;

// q268 #easy #missing-number #java
public class Solution1 {
    public int missingNumber(int[] nums) {
        int[] resultCheckArr = new int[nums.length + 1];
        for (int i = 0; i < resultCheckArr.length; i++) {
            resultCheckArr[i] = -1;
        }
        for (int numVal : nums) {
            resultCheckArr[numVal] = 0;
        }
        for (int i = 0; i < resultCheckArr.length; i++) {
            if (resultCheckArr[i] == -1) {
                return i;
            }
        }
        return -1;
    }
}
