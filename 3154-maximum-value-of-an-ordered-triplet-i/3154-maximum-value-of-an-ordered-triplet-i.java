class Solution {
    public long maximumTripletValue(int[] nums) {
        long max = 0;
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = nums[0];
        for(int i=1; i<n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], nums[i]);
        }

        rightMax[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        for(int i=1; i<n-1; i++) {
            long cur = (long)(leftMax[i-1] - nums[i]) * rightMax[i+1];
            max = Math.max(cur, max);
        }

        return max;
    }
}