class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        int cur = -prices[0];
        for(int i=1; i<n; i++) {
            dp[i] = Math.max(dp[i-1], cur+prices[i]);
            cur = Math.max(cur, -prices[i]);
        }
        return dp[n-1];
    }
}