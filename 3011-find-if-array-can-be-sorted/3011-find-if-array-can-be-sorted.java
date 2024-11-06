class Solution {
    public boolean canSortArray(int[] nums) {
        int idx = 0;
        int n = nums.length;
        for(int i=1; i<n; i++) {
            int x1 = Integer.bitCount(nums[i-1]);
            int x2 = Integer.bitCount(nums[i]);
            if(x1 != x2) {//같은 경우 달라지는 시기에 한번에 정렬한다.
                Arrays.sort(nums, idx, i);
                idx = i;
            } 
        }
        if(idx != n-1)
            Arrays.sort(nums, idx, n);
        
        return check(nums);
    }
    
    public boolean check(int[] nums) {
        for(int i=1; i < nums.length; i++) {
            if(nums[i-1] > nums[i]) {
                return false;
            }
        }
        return true;
    }
}