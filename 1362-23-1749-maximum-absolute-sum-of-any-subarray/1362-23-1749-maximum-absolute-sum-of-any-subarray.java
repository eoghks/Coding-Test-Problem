class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int presum = 0;
        int max = 0;
        int cur = 0;
        int pmax = 0;
        int nmin = 0;
        for(int i=0; i<n; i++) {
            cur = nums[i];
            presum+= cur;
            if(cur < 0) {
                max = Math.max(max, Math.abs(pmax-presum));
                nmin= Math.min(nmin, presum);
            } else {
                max = Math.max(max,Math.abs(nmin-presum));
                pmax = Math.max(pmax,presum);
            }
        }
        return max;
    }
}