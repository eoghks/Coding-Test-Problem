class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] res = new boolean[queries.length];
        int[] temp = new int[nums.length];
        for(int i=1; i<nums.length; i++) {
            temp[i] = temp[i-1];
            if(nums[i-1]%2 == nums[i]%2) {
                temp[i]++;
            }
        }
        
        for(int i=0; i<queries.length; i++) {
            int st = queries[i][0];
            int end = queries[i][1];
            int cnt = temp[end] - temp[st];
            res[i] = cnt>0? false: true;
        } 
        
        return res;
    }
}