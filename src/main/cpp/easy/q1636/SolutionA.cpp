class Solution {
public:
    vector<int> frequencySort(vector<int>& nums) {
        unordered_map<int, int> freq;
        for (int n : nums)
            freq[n]++;

        sort(nums.begin(), nums.end(), [&](int a, int b) {
            return freq[a] == freq[b] ? a > b : freq[a] < freq[b];
        });

        return nums;
    }
};