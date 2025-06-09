package medium.q287;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionC {
    public int findDuplicate(int[] nums) {
        Set<Integer> check = new HashSet<>();
        return Arrays.stream(nums)
                .boxed()
                .filter(num -> !check.add(num))
                .findFirst()
                .orElse(0);
    }
}
