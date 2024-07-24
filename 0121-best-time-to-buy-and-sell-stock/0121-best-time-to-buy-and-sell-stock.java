class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int result = 0;
        if(n < 2)
            return result;

        int[] dp = new int[n];
        for(int i = n - 1; i >= 1; i--) {
           if(dp[i] > 0)
               dp[i-1] = prices[i] - prices[i-1] + dp[i];
            else
                dp[i-1] =  prices[i] - prices[i-1];
            
            if(result < dp[i-1])
                result = dp[i-1];
        }
            
        return result;
    }
}