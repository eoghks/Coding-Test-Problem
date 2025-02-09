class Solution {
    //j - i = nums[j] - nums[i]
    //nums[i] -i = nums[j] -j
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        long cnt = 0;
        int n = nums.length;
        //0에서부터 1씩 증가하므로 모든 쌍에 대해서 체크 가능
        for(int i=0; i< n; i++) {
            int key = nums[i] - i;
            cnt += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        //총 합에서 good을 제외
        return (long) n * (n - 1) / 2 - cnt;
    }
}