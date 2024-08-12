class Solution {
    int result = Integer.MAX_VALUE;
    int[] nums;
    public int distributeCookies(int[] cookies, int k) {
        nums = new int[k];
        soultion(cookies, nums, 0);
        return result;
    }
    
    public void soultion(int[] cookies, int[]nums, int cur) {
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
            nums[i]+=cookies[cur];
            soultion(cookies, nums, cur+1);
            nums[i]-=cookies[cur];
        }
    }
}