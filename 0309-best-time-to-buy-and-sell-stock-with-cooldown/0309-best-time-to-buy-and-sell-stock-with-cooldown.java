class Solution {
    /*
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];

        for(int i=1; i<n; i++) {
            if(i==1) {
                dp[1] = Math.max(prices[1] - prices[0], 0);
            } else {
                dp[i] = dp[i-1];
                for(int j=0; j<i; j++) {
                    int prev = j>=2? dp[j-2]:0;
                    dp[i] = Math.max(dp[i], prev + prices[i] - prices[j]);
                }
            }
        }
        return dp[n-1];
    }*/
    //dp[j]+prices[i]-prices[j] => dp[j]-prices[j] ==> max ==> max+prices[i]
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];

        int max = Integer.MIN_VALUE; // dp[j - 2] - prices[j] ==> 가장 돈을 많이 벌고 2일 뒤 주식을 산 경우
        for(int i=0; i<n; i++) {
            if(i < 2) {
                max = Math.max(max, -prices[i]);
            }
            if(i == 0) {
                dp[0] = 0;
            } else if(i==1) {
                dp[1] = Math.max(prices[1] - prices[0], 0);
            } else {
                dp[i] = Math.max(dp[i - 1], max + prices[i]);
                max = Math.max(max, dp[i - 2] - prices[i]);
            }
        }
        return dp[n-1];
    }
}