package Easy;
// #905
// https://leetcode.com/problems/sort-array-by-parity/
public class Sort_array_by_parity {
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