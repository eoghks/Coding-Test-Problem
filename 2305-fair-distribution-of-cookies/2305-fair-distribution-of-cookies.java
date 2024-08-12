class Solution {
    int result = Integer.MAX_VALUE;
    int[] nums;
    public int distributeCookies(int[] cookies, int k) {
        nums = new int[k];
        soultion(cookies, nums, 0, k);
        return result;
    }
    //zeroCount -> 현재 0개의 쿠키를 가진 아이들 수
    public void soultion(int[] cookies, int[]nums, int cur, int zeroCount) {
        //최소 한명의 아이는 하나의 쿠키 가방은 가질 수 있다.
        //왜냐하면 2 <= k <= cookies.length 이기때문이다.
        //따라서 현재 0개의 쿠키를 가진 아이들 수가 남은 쿠기 가방 수보다 적은 경우 
        //아이들은 최소 하나의 쿠키 가방을 가질 수 없다. 따라서 더이상 확인할 필요가 없다.
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