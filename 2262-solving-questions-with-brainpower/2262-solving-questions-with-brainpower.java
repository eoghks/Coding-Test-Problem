class Solution {
    //dp[i]의 최대 값음 dp[i+breakpoint+1]의 값과 현재 포인트의 값을 합친것이다.
    //point       5 6 4 2
    //break point 2 1 4 5
    //dp[3] -> 2
    //dp[2] -> 4
    //dp[1] -> max(6+dp[1+1+1=3], dp[2]) -> max(8,4) -> 8
    //dp[0] -> max(5+dp[0+2+1=3], dp[1]) -> max(7, 8) -> 8
    //result -> 8
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        dp[n-1] = questions[n-1][0];
        for(int i=n-2; i>=0; i--) {
            int idx = i + questions[i][1] + 1;
            //brainpower가 n을 넘어가는 경우에는 현재 point만 획득(다음 문제를 풀수 없기 때문)
            if(idx >= n) {
                dp[i] = questions[i][0];
            } else {
                //dp[idx]는 dp[idx]의 최대값임
                dp[i] = questions[i][0] + dp[idx];
            }
            //이전 경우와 현재 point의 합을 구함
            dp[i] = Math.max(dp[i+1], dp[i]);
        }
        return dp[0];
    }
}