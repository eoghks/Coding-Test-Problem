class Solution {
    //j - i = nums[j] - nums[i]
    //nums[i] -i = nums[j] -j
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        long cnt = 0;
        int n = nums.length;
        for(int i=0; i< n; i++) {
            int key = nums[i] - i;
            cnt += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        return (long) n * (n - 1) / 2 - cnt;
    }
}