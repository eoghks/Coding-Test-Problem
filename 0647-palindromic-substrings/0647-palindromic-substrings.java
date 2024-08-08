class Solution {
    public int countSubstrings(String s) {
        int cnt = 0;
        char[] chArray = s.toCharArray();
        int n = chArray.length;
        boolean[][] dp = new boolean[n][n];
        for(int i=0; i<n; i++) {
            dp[i][i] = true;
            cnt++;
        }
        for(int j = 1; j < n; j++) {
            for(int i = 0; i < n-j; i++ ) {
                //System.out.println("-------");
                //System.out.println(chArray[i] == chArray[i+j]);
                //System.out.println((dp[i+1][i+j-1] || j == 1));
                if(chArray[i] == chArray[i+j] && (dp[i+1][i+j-1] || j == 1)) {
                    dp[i][i+j] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}