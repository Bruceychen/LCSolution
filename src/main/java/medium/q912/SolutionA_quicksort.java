package medium.q912;

// may refer to
// https://www.youtube.com/watch?v=Vtckgz38QHs
public class SolutionA_quicksort {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quicksort(int[] nums, int start, int end) {
        if (start >= end) return;
        int midPivot = partition(nums, start, end);
        quicksort(nums, start, midPivot - 1);
        quicksort(nums, midPivot + 1, end);

    }

    private int partition(int[] nums, int start, int end) {
        // Randomized pivot to avoid worst-case O(n^2)
        int pivotIndex = start + (int) (Math.random() * (end - start + 1));
        swap(nums, end, pivotIndex); // Move random pivot to start

        int pivot = nums[end];
        int i = start - 1;

        for (int j =start; j<=end;j++) {
            if (nums[j]< pivot){
                i++;
                swap(nums, i, j);
            }
        }
        i++;
        swap(nums, i, end);

        return i;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] + nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] = nums[i] - nums[j];
        }
    }

}
