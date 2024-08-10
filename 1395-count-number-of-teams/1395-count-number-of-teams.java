class Solution {
    public int numTeams(int[] rating) {
        int cnt = 0;
        boolean[][] dp = new boolean[rating.length][rating.length];
        
        for(int i = 0; i < rating.length -1; i++) {
            for(int j = i+1; j< rating.length; j++) {
                if(rating[i] < rating[j])
                    dp[i][j] = true;
            }
        }
        
        for(int i = 0; i < rating.length -2; i++) {
            for(int j = i+1; j<rating.length-1; j++) {
                for(int k = j+1; k<rating.length; k++) {
                    if(dp[i][j] == dp[j][k])
                        cnt++;
                }
            }
        }
        
        
        return cnt;
    }
}