class Solution {
    public int maxWidthRamp(int[] nums) {
        int res =0;
        int n = nums.length;
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<n; i++) {
            if(s.isEmpty() || nums[s.peek()] > nums[i])
                s.add(i);
        }
        for(int i = n-1; i>res; i--) {
            while(s.isEmpty() == false && nums[s.peek()] <= nums[i]) {
                res = Math.max(res, i-s.pop());
            }
        }
        return res;
    } 
}