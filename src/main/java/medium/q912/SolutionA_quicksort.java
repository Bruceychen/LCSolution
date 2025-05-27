package medium.q912;

public class SolutionA_quicksort {
    public int[] sortArray(int[] nums) {
        int[] res = new int[nums.length];
        if (nums == null || nums.length == 0)
            return res;
        quicksort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    private void quicksort(int[] nums, int l, int r) {
        if (l >= r)
            return;
        int mid = partition(nums, l, r);
        quicksort(nums, l, mid - 1);
        quicksort(nums, mid + 1, r);

    }

    private int partition(int[] nums, int l, int r) {
        // Randomized pivot to avoid worst-case O(n^2)
        int pivotIndex = l + (int) (Math.random() * (r - l + 1));
        swap(nums, l, pivotIndex); // Move random pivot to start

        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot)
                r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot)
                l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
