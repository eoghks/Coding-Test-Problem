class Solution {
    int dp[][];
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int i=0;i<n;i++)
            dp[0][i]=1;
        for(int i=0;i<m;i++)
            dp[i][0]=1;
        
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
        /*
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