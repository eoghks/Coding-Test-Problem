class Solution {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int i = 0;
        int j = 0;
        int n = nums.length;
        long res = 0;
        while(i<n) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            i++;
            //제일 작은 키와 제일 큰키를 비교
            while(Math.abs(map.firstEntry().getKey()-map.lastEntry().getKey())>2) {
                //j는 키와 상관이 없다.
                map.put(nums[j],map.getOrDefault(nums[j],0)-1);
                if(map.get(nums[j])==0){
                    map.remove(nums[j]);
                }
                j++;
            }
            res+=i-j;
        }
        return res;
    }
}