class Solution {
    public int maxProfit(int[] prices) {
        //DP Practice
        /*
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
        */
        // real soultion
        int min = prices[0];
        int result = 0;
        for(int i = 1; i < prices.length; i++) {
            if(min > prices[i])
                min = prices[i];
            result = Math.max(result, prices[i] - min);
        }
        return result;
    }
}