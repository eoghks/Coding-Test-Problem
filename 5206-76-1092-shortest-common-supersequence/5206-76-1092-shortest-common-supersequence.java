class Solution {
    //dp[i][j] => str1의 0~i-1번째까지 문자열과 str2의 0~j-1까지의 두 문자열에서 동일한 순서로 나타나는 문자의 수
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();
        
        while(i>0 && j>0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                //str2를 삽입할지 str1을 삽입할지 정함
                //str1을 삽입하면 발생할 str1의 0~i-2와 str2의 0~j-1까지 동일한 문자 수와
                //str2를 삽입시 발생할 str1의 0~i-1와 str2의 0~j-2까지 동일한 문자 수 중 뭐가 더큰지 비교
                sb.append(str1.charAt(i - 1));
                i--;
            } else {
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }

        //str1이 남은 경우
         while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }
        
        //str2가 남은 경우
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }
        
        return sb.reverse().toString();
    }
}