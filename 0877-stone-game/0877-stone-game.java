class Solution {
    public boolean stoneGame(int[] piles) {
        /*
        int n = piles.length;
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j< n ; j++) {
                dp[i][j] = -1;
            }
        }
        
        return solution(piles, 0, n-1, true, dp) > 0; */
        return true;
    }
    /*
    public int solution(int[] piles, int left, int right, boolean aliceTurn, int[][]dp) {
        if(left > right)
            return 0;
        if(dp[left][right] != -1)
            return dp[left][right];

        int sign = 1;
        if(aliceTurn == false)
            sign = -1;
        
        int beginning = sign * piles[left] + solution(piles, left+1, right, !aliceTurn, dp);
        int end =  sign * piles[right] + solution(piles, left, right-1, !aliceTurn, dp);
        dp[left][right] = Math.max(beginning, end);
        return dp[left][right];
        
    }*/
}