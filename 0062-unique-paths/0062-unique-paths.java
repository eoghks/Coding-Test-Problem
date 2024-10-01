class Solution {
    int dp[][];
    public int uniquePaths(int m, int n) {
        // Bottom-up
        int[][] dp = new int[m+1][n+1];
        
        for(int i=1;i<=n;i++)
            dp[1][i]=1;
        for(int i=1;i<=m;i++)
            dp[i][1]=1;
        
        for(int i=2;i<=m;i++) {
            for(int j=2;j<=n;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m][n];
        /* Top-Down
        dp = new int[m+1][n+1];
        dp[1][1] = 1;
        return solution(m, n);
        */
    }
    
    public int solution(int m, int n) {
        if(dp[m][n] == 0 && m != 0 && n != 0)
            dp[m][n] = solution(m-1, n) + solution(m, n-1);
        return dp[m][n];
    }
}