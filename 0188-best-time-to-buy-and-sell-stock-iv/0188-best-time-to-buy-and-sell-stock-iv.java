class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;
        
        //if k >= n/2, then you can make maximum number of transactions.
        if (k >=  n/2) {
            int maxPro = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            }
            return maxPro;
        }

        //dp[i][j] = 최대 i번 거래로, j일에 얻을 수 있는 최대 이익
        int[][] dp = new int[k+1][n];
        for(int i=1; i<=k; i++) {
            int curMax = dp[i-1][0] - prices[0];
            for(int j=1; j<n; j++) {
                //dp[i][j - 1]: 오늘 아무것도 안 함
                //prices[j] + (과거에 산 시점의 최대) → 이걸 localMax로 효율 저장
                dp[i][j] = Math.max(dp[i][j-1],  prices[j] + curMax);
                //i =1 일때 curMax에 의해 가장 싼날 사고 가장 비싼날 팔 수 있게 된다.
                //i=2 부터는 i-1번 거래햇을때에서 오늘 매수한 금액과 현재 이득을 비교 
    		    curMax = Math.max(curMax, dp[i-1][j] - prices[j]);
            }
        }
       return dp[k][n-1];
    }
}