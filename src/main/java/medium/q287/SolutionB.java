package medium.q287;

import java.util.HashSet;
import java.util.Set;

public class SolutionB {
    public int findDuplicate(int[] nums) {
        Set<Integer> check = new HashSet<>();
        for (int i: nums){
            if (!check.add(i)) return i;
        }
        return -1;
    }

}
