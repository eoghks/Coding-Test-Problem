class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] asc = new int[n+1];
        asc[0] = 1;
        for(int i=0; i<n; i++) {
            asc[i+1] = asc[i] * nums[i];
        }
        int[] desc = new int[n+1];
        desc[n] = 1;
        for(int i=n-1; i>=0; i--) {
            desc[i] = desc[i+1] * nums[i];
        }

        for(int i=1; i<=n; i++) {
            res[i-1] = asc[i-1] * desc[i];
        }

        return res;
    }
}