class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] res = new boolean[queries.length];
        int[] temp = new int[nums.length];
        //연속적으로 홀수(짝수)가 나오면 1을 더함
        //temp[i]는 0부터 i번째 index까지 인접합 원소가 짝수나 홀수인 경우의 수
        for(int i=1; i<nums.length; i++) {
            temp[i] = temp[i-1];
            if(nums[i-1]%2 == nums[i]%2) {
                temp[i]++;
            }
        }
        //0부터 end까지 special한 경우에서 0부터 st까지 special한 경우를 뺀건
        //st부터 end까지 special 경우의 수
        //따라서, 해당 값이 0이면 해당 subarray는 special하다고 할수 있다.
        for(int i=0; i<queries.length; i++) {
            int st = queries[i][0];
            int end = queries[i][1];
            int cnt = temp[end] - temp[st];
            res[i] = cnt>0? false: true;
        } 
        
        return res;
    }
}