class Solution {
    int dp[][];
    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        dp[1][1] = 1;
        return solution(m, n);
    }
    
    public int solution(int m, int n) {
        if(dp[m][n] == 0 && m != 0 && n != 0)
            dp[m][n] = solution(m-1, n) + solution(m, n-1);
        return dp[m][n];
    }
}