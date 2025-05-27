package medium.q912;

public class SolutionA_quicksort {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quicksort(int[] nums, int l, int r) {
        if (l >= r)
            return;
        int mid = partition(nums, l, r);
        quicksort(nums, l, mid - 1);
        quicksort(nums, mid + 1, r);

    }

    private int partition(int[] nums, int l, int r) {
        int pivotindex = l + (int) (Math.random() * (r - l + 1));
        swap(nums, l, pivotindex);

        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }

    private void swap(int[] nums, int l, int pivotindex) {
        if (l != pivotindex) {
            nums[l] = nums[l] + nums[pivotindex];
            nums[pivotindex] = nums[l] - nums[pivotindex];
            nums[l] = nums[l] - nums[pivotindex];
        }
    }

}
