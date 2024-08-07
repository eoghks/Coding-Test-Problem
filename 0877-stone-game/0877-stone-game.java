class Solution {
    //top-down
    /*
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j< n ; j++) {
                dp[i][j] = -1;
            }
        }
        
        return solution(piles, 0, n-1, true, dp) > 0; 
    }
    
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
    
    //bottom up
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        
        //크기가 2인 배열부터 차분히 구함 -> 3 -> ... ->n 
        for(int j = 1; j < n; j++) {
            for(int i =0; i < n -j; i++) {
                dp[i][i+j] = Math.max(piles[i] - dp[i+1][i+j], piles[i+j] - dp[i][i+j-1] );
            }
        }
        
        
        return dp[0][n-1] > 0;
    }
}
