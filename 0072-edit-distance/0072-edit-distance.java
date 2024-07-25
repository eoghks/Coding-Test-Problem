class Solution {
    public int minDistance(String word1, String word2) {
        char[] chs1 = word1.toCharArray();
        char[] chs2 = word2.toCharArray();
        
        int n = chs1.length;
        int m = chs2.length;
        
        int[][] dp = new int[n + 1][m+1];
        for(int i =0; i <= n; i++){
            dp[i][0] = i;
        }
        for(int i =0; i <= m; i++) {
            dp[0][i] = i;
        }
        
        for(int i=0; i < n; i++) {
            for(int j=0; j <m; j++) {
                if(chs1[i] == chs2[j]) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    int cost = dp[i][j]; // replace
                    int insert = dp[i+1][j];
                    int delete = dp[i][j+1];
                    
                    if(cost > insert) {
                        cost = insert;
                    }
                    if(cost > delete) {
                        cost = delete;
                    }
                    
                    dp[i+1][j+1] = cost + 1;
                }
                
            }
        }
        return dp[n][m];
        
    }
}