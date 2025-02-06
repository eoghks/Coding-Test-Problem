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
            //cnt>1이상 이여야 짝이 존재
            if(cnt>1) {
                //앞에 짝 2개 뒤에 짝 2개 해서 4개
                //앞에 올수 있는 경우의수가 cnt개라면 뒤에는 1을 뺀 cnt-1개
                res += cnt * (cnt-1) * 4;
            }
        }
        return res;
    }
}