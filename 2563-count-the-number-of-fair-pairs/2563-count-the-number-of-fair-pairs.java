class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long res = 0;
        int n = nums.length;
        for(int i=0; i < n; i++) {
            int low = getLower(nums, i+1, n, lower-nums[i]);
            int up = getUpper(nums, i+1, n, upper-nums[i]);
            res += up - low;
        }
        return res;
    }

    private int getLower(int[] nums, int st, int end, int target) {
        //target 값보다 큰 가장 작은 index를 구한다.
        while(st < end) {
            int mid = st + (end-st)/2;
            if(nums[mid] >= target)
                end = mid;
            else
                st = mid+1;
        }
        return st;
    }
    
    private int getUpper(int[] nums, int st, int end, int target) {
        //target 값보다 작고 가장 큰 index를 구한다.
        while(st < end) {
            int mid = st + (end-st)/2;
            if(nums[mid] > target)
                end = mid;
            else
                st = mid+1;
        }
        return st;
    }
}