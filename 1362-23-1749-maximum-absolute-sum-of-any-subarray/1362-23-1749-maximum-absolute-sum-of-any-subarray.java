class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int max = 0;
        int cur = 0;
        int pmax = 0;
        int nmin = 0;
        for(int i=0; i<n; i++) {
            cur = nums[i];
            sum+= cur;
            
            if(cur < 0) {
                max = Math.max(max, Math.abs(pmax-sum));
                nmin= Math.min(nmin, sum);
            } else {
                max = Math.max(max,Math.abs(nmin-sum));
                pmax = Math.max(pmax, sum);
            }
        }
        return max;
    }
}