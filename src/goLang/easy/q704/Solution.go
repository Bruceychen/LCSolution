package q704

func binarySearch(array []int, target int) int {
	left, right := 0, len(array)-1
	for left <= right {
		mid := left + (right-left)/2
		if array[mid] == target {
			return mid
		}
		if array[mid] < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return -1
}
