class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n= nums.length;
        int res = 0;
        for(int i =0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int temp = nums[i]*nums[j];
                map.put(temp, map.getOrDefault(temp, 0)+1);
            }
        }
        for(int cnt: map.values()) {
            if(cnt>1) {
                res += cnt * (cnt-1) * 4;
            }
        }
        return res;
    }
}