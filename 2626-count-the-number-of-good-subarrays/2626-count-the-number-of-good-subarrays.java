class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long cnt = 0; 
        int left = 0;
        for(int i=0; i<nums.length; i++) {
            //이전에 2개의 nums[i]가 있을때 1개가 추가된다면 2개의 쌍이 추가됨
            //5개의 원소가 존재할 때 쌍의 수는 5*4/2 == n(n-1)/2
            k-= map.getOrDefault(nums[i], 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0 )+1);
            while(k<=0) {
                map.put(nums[left], map.get(nums[left])-1);
                k+=map.get(nums[left++]);
            }
            //만약 left가 3이라면 앞에 2,1,0에 대해서 subarry가 조건을 만족하는 것이므로 left만큼 더 할 수 있다.
            cnt +=left;
        }
        return cnt;
    }
}