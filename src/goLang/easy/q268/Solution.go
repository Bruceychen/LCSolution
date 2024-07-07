package q268

// q268 #easy #missing-number #Go
func missingNumber(nums []int) int {
	resultCheckArr := make([]int, len(nums)+1)
	for i := range resultCheckArr {
		resultCheckArr[i] = -1
	}

	for _, numVal := range nums {
		resultCheckArr[numVal] = 0
	}

	for i, val := range resultCheckArr {
		if val == -1 {
			return i
		}
	}
	return -1
}
