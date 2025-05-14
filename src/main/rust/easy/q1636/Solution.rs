use std::collections::HashMap;

impl Solution {
    pub fn frequency_sort(nums: Vec<i32>) -> Vec<i32> {
        let mut freq = HashMap::new();
        for &num in &nums {
            *freq.entry(num).or_insert(0) += 1;
        }

        let mut nums = nums;
        nums.sort_by(|a, b| {
            let fa = freq[a];
            let fb = freq[b];
            if fa == fb {
                b.cmp(a) // value descending
            } else {
                fa.cmp(&fb) // freq ascending
            }
        });

        nums
    }
}
