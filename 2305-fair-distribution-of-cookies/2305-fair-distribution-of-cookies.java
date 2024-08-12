class Solution {
    int result = Integer.MAX_VALUE;
    int[] nums;
    public int distributeCookies(int[] cookies, int k) {
        nums = new int[k];
        soultion(cookies, nums, 0, k);
        return result;
    }
    
    public void soultion(int[] cookies, int[]nums, int cur, int zeroCount) {
        if(cookies.length - cur < zeroCount) {
            return;
        }
        
        if(cur == cookies.length) {
            int temp =0;
            for(int i=0; i<nums.length; i++) {
                temp = Math.max(temp, nums[i]);
            }
            result = Math.min(result, temp);
            return;
        }
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] + cookies[cur] > result)
                continue;
            zeroCount -= nums[i] == 0? 1:0;
            nums[i]+=cookies[cur];
            soultion(cookies, nums, cur+1, zeroCount);
            nums[i]-=cookies[cur];
            zeroCount += nums[i] == 0? 1:0;
        }
    }
}