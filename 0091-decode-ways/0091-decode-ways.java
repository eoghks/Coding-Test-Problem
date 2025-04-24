class Solution {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if(chars[0] =='0'){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            if(chars[i-1] >= '1' && chars[i-1] <= '9') {
                dp[i] += dp[i-1];
            }
            if(chars[i-2] == '1' || (chars[i-2] == '2' && chars[i-1] <='6')) {
                dp[i] +=dp[i-2];
            }
        }
        return dp[n];
    }
}