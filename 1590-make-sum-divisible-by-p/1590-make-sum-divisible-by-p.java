class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int res = n;
        int need = 0;
        for(int num: nums){
            need=(need+num)%p;
        }
        if(need == 0)
            return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int cur = 0;
        for(int i=0; i<n; i++) {
            cur= (cur + nums[i])%p;
            map.put(cur, i);
            int want = (cur - need + p)%p;
            res = Math.min(res, i - map.getOrDefault(want, -n));
        }
        return res == n?-1:res;
        
        
    }
}