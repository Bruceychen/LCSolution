package medium.q238;


// can divided
class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int zeroCount = 0;
        int nonzeroProduct =1;
        for (int i:nums){
            if (i==0){
                zeroCount++;
            }else{
                nonzeroProduct = nonzeroProduct*i;
            }
        }
        if (zeroCount > 1) {
            for (int i = 0; i < nums.length; i++) {
                output[i] = 0;
            }
        } else if (zeroCount == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]==0) {
                    output[i] = nonzeroProduct;
                } else {
                    output[i] = 0;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                output[i] = nonzeroProduct / nums[i];
            }
        }
        return output;
    }
}
