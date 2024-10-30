class Solution {
    //use dp
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        int res =0;
        
        //오름 차순 구하기
        for(int i=0; i<n; i++) {
            int max = 0;
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    max = Math.max(max, dp1[j]);
                }
            }
            dp1[i] = max + 1;
        }
        
        //내림 차순 구하기
        for(int i = n-1; i>=0; i--) {
            int max = 0;
            for(int j = n-1; j>i; j--) {
                if(nums[j] < nums[i])
                    max = Math.max(max, dp2[j]);
            }
            dp2[i] = max+1;
        }
        
        for(int i=1; i<n-1; i++) {
            if(dp1[i] > 1 && dp2[i] > 1)
                res = Math.max(res, dp1[i]+dp2[i]-1);
        }
        
        return n-res;
    }
}