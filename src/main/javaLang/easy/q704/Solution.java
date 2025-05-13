package main.javaLang.easy.q704;

// 704 #easy #Binary Search #java #CoreConcept
public class Solution {
    public static int binarySearch(int[] array, int target){
        int lp, rp, mp = 0;
        lp = 0;
        rp = array.length - 1;
        mp = lp + (rp - lp) / 2;

        if (target == array[lp])
            return lp;
        if (target == array[rp])
            return rp;
        while (lp < rp) {
            if (target == array[mp]) {
                return mp;
            } else if (target > array[mp]) {
                lp = mp + 1;
            } else if (target < array[mp]) {
                rp = mp - 1;
            } else {
                return -1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 7;

        int result = binarySearch(array, target);

        if (result == -1) {
            System.out.println("Target not found in the array.");
        } else {
            System.out.println("Target found at index: " + result);
        }
    }
}
