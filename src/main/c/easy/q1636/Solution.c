#include <stdio.h>
#include <stdlib.h>

#define OFFSET 100
#define RANGE 201

int cmp(const void* a, const void* b, void* freq_map) {
    int x = *(int*)a;
    int y = *(int*)b;
    int* freq = (int*)freq_map;

    if (freq[x + OFFSET] != freq[y + OFFSET])
        return freq[x + OFFSET] - freq[y + OFFSET];
    return y - x; // descending value
}

int* frequencySort(int* nums, int numsSize, int* returnSize) {
    int* freq = calloc(RANGE, sizeof(int));
    for (int i = 0; i < numsSize; i++) {
        freq[nums[i] + OFFSET]++;
    }

    qsort_r(nums, numsSize, sizeof(int), cmp, freq);

    *returnSize = numsSize;
    free(freq);
    return nums;
}
