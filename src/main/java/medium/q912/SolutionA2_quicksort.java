package medium.q912;

// may refer to
// https://www.youtube.com/watch?v=Vtckgz38QHs
public class SolutionA2_quicksort {
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
        // randomize to avoid worst case
        int pivotindex = start + (int) (Math.random() * (end - start + 1));
        swap(nums, start, pivotindex);

        int pivot = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= pivot) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= pivot) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        return start;
    }

    private void swap(int[] nums, int start, int pivotindex) {
        if (start != pivotindex) {
            nums[start] = nums[start] + nums[pivotindex];
            nums[pivotindex] = nums[start] - nums[pivotindex];
            nums[start] = nums[start] - nums[pivotindex];
        }
    }

}
