class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        int n = nums.length;
        for (; j < n; j++)
            if (nums[j] - nums[i] > k * 2)
                i++;
        return j - i;
    }
}