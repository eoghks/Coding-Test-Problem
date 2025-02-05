class Solution {
    public boolean isArraySpecial(int[] nums) {
        int prev= nums[0]%2;
        for(int i=1; i<nums.length; i++) {
            int cur = nums[i]%2;
            if(cur == prev)
                return false;
            prev = cur;
        }

        return true;
    }
}