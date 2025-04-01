class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        dp[n-1] = questions[n-1][0];
        for(int i=n-2; i>=0; i--) {
            int idx = i + questions[i][1] + 1;
            if(idx >= n) {
                dp[i] = questions[i][0];
            } else {
                dp[i] = questions[i][0] + dp[idx];
            }

            dp[i] = Math.max(dp[i+1], dp[i]);
        }
        return dp[0];
    }
}