class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i  + 1 < 3 || dp[i + 1][j - 1]);
                if(dp[i][j]) ++res;
            }
        }
        return res;
        /*
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
                if(chArray[i] == chArray[i+j] && (dp[i+1][i+j-1] || j == 1)) {
                    dp[i][i+j] = true;
                    cnt++;
                }
            }
        }
        return cnt;*/
    }
}