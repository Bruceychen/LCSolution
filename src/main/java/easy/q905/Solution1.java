package easy.q905;
// #905 #sort-array-by-parity #java #easy
// https://leetcode.com/problems/sort-array-by-parity/
public class Solution1 {
    public int[] sortArrayByParity(int[] A) {
        int[] odd = new int[A.length];
        int[] outcome = new int[A.length];
        int index=0;
        int indexOdd=0;
        for(int i:A){
            if(i%2==0){
                outcome[index]=i;
                index++;
            }else{
                odd[indexOdd]=i;
                indexOdd++;
            }
        }
        for(int j=0;j<indexOdd;j++){
            outcome[index]=odd[j];
            index++;
        }
        return outcome;
    }
}
