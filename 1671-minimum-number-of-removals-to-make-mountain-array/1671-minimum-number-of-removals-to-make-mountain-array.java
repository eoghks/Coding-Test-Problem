class Solution {
    //use dp
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        int res =0;
        
        //오름 차순 구하기
        for(int i=0; i<n; i++) {
            int max = 0;
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    max = Math.max(max, dp1[j]);
                }
            }
            dp1[i] = max + 1;
        }
        
        //내림 차순 구하기
        for(int i = n-1; i>=0; i--) {
            int max = 0;
            for(int j = n-1; j>i; j--) {
                if(nums[j] < nums[i])
                    max = Math.max(max, dp2[j]);
            }
            dp2[i] = max+1;
        }
        
        //dp의 값이 2이상인 경우 오름차순 혹은 내림차순
        //따라서 마운틴이 존재한다고 파악하여 가장긴 길이를 구함(단 꼭대기는 양쪽에 포함되므로 -1)
        //1, 3 , 1이 존재한다면 dp1[1] = 2(1->3) dp2[1] = 2(3->1) ==> 3이 두번 포함됨 따라서 실제 길이는 2+2-1
        for(int i=1; i<n-1; i++) {
            if(dp1[i] > 1 && dp2[i] > 1)
                res = Math.max(res, dp1[i]+dp2[i]-1);
        }
        
        return n-res;
    }
}