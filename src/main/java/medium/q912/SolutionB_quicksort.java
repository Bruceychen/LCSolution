package medium.q912;

public class SolutionB_quicksort {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quicksort(int[] nums, int start, int end) {
        if (start >= end) return;

        // Add depth limit to prevent worst case (optional optimization)
        int midPivot = partition(nums, start, end);
        quicksort(nums, start, midPivot - 1);
        quicksort(nums, midPivot + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        // Better randomization - choose random pivot and swap to end
        int pivotIndex = start + (int) (Math.random() * (end - start + 1));
        swap(nums, pivotIndex, end);

        int pivot = nums[end];
        int i = start - 1;

        // Fixed: loop should exclude the pivot at position 'end'
        for (int j = start; j < end; j++) {  // Changed from j <= end
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        i++;
        swap(nums, i, end);  // Place pivot in correct position
        return i;
    }

    // Safe swap function - no overflow risk
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
