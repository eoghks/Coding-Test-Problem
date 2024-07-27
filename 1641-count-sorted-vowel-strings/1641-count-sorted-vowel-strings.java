class Solution {
    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        for(int i=0; i < 5; i++){
            dp[i] = 1;
        }
        for(int i = 1; i < n; i++) {
            dp[4] = dp[4] + dp[3] + dp[2] + dp[1] + dp[0];
            dp[3] = dp[3] + dp[2] + dp[1] + dp[0];
            dp[2] = dp[2] + dp[1] + dp[0]; 
            dp[1] = dp[1] + dp[0]; 
        }
        
        return dp[4] + dp[3] + dp[2] + dp[1] + dp[0];
    }
}