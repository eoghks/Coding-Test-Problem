class Solution {
    public long maximumTripletValue(int[] nums) {
        long res = 0;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int diff = 0;

        for(int i=0; i<n; i++) {
            //max < nums[i]라면 i+1이후의 값은 nums[i]에 빼는 것이 nums[i] - nums[j]가 최대값을 구할 수 있다.
            max = Math.max(max, nums[i]);
            if(i>=2) {
                //먼저하는 이유는 k와 j와 같으면 안되기 때문
                res = Math.max(res, (long)diff * nums[i]);
            }
            if(i>=1) {
                //다음 최대값으로 활용
                diff = Math.max(diff, max - nums[i]);
            }
        }
        return res;
    }
}