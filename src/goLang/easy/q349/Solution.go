// q349 #easy #Intersection of Two Arrays #go
func intersection(nums1 []int, nums2 []int) []int {
	set1 := make(map[int]struct{})
	for _, num := range nums1 {
		set1[num] = struct{}{}
	}

	set2 := make(map[int]struct{})
	for _, num := range nums2 {
		set2[num] = struct{}{}
	}

	resultSet := make(map[int]struct{})
	for num := range set1 {
		if _, found := set2[num]; found {
			resultSet[num] = struct{}{}
		}
	}

	result := make([]int, 0, len(resultSet))
	for num := range resultSet {
		result = append(result, num)
	}

	return result
}
