class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        int j = 0;
        int k = 1;
        for(int i = 1; i<=n; i++) {
            dp[i] = 1 + dp[j];
            if(i == Math.pow(2, k) -1) {
                k++;
                j = 0;
            } else {
                j++;
            }
        }
        return dp;
    }
}