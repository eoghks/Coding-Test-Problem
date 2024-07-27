class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n+1][5];
        for(int i=0; i < 5; i++){
            dp[1][i] = 1;
        }
        for(int i = 2; i <= n; i++) {
            dp[i][0] = 1;
            for(int j = 1; j < 5; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        
        return dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4];
    }
}