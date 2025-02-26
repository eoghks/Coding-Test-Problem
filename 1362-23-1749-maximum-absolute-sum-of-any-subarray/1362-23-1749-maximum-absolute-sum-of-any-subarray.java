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
            
            //pmax = nums[0] +... nums[i] 까지 중에 가장 큰 값
            //pmin = nums[0] +... nums[i] 까지 중에 가장 작은 값
            //pmax-sum == (nums[0] + ... + nums[i]) - (nums[0] + ... nums[j]) = nums[i]+...nums[j]
            //nmin - sum == (nums[0] + ... + nums[i]) - (nums[0] + ... nums[j]) = nums[i]+...nums[j]
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