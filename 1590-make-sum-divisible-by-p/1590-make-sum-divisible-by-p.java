class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int res = n;
        long sum = 0;
        for(int num: nums){
            sum+=num;
        }
        int need = (int)(sum%p);
        if(need == 0)
            return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int cur = 0;
        for(int i=0; i<n; i++) {
            cur= (cur + nums[i])%p;
            map.put(cur, i); //현재 나머지를 Map에 저장
            int want = (cur - need + p)%p; //현재 나머지가 Need 나머지가 되기위해 필요한값을 구한다.
            res = Math.min(res, i - map.getOrDefault(want, -n));
        }
        return res == n?-1:res;
    }
}