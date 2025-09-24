package medium.q238;

import java.util.stream.IntStream;

// can divided
class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int zeorcount =0;
        int nonzeroProduct =1;
        for (int i:nums){
            if (i==0){
                zeorcount++;
            }else{
                nonzeroProduct = nonzeroProduct*i;
            }
        }
        if(zeorcount>1){
            IntStream.range(0,nums.length-1).forEach(i-> output[i]=0);
        } else if (zeorcount==1) {
            for (int i =0;i<nums.length;i++) {
                if (nums[i]==0) {
                    output[i] = nonzeroProduct;
                } else {
                    output[i] = 0;
                }
            }
        } else {
            for (int i =0;i<nums.length;i++) {
                output[i] = nonzeroProduct/nums[i];
            }
        }
        return output;
    }
}
