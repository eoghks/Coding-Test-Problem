class Solution {
    /* time limit
    public int lps(char[] s, int i, int j) {
        if(i==j)
            return 1;
        if(s[i]==s[j] && i+1 == j)
            return 2;
        if(s[i] ==s[j])
            return lps(s, i+1, j-1) + 2;
        
        return Math.max(lps(s, i, j-1), lps(s, i+1, j));
    }*/
    
    public int longestPalindromeSubseq(String s) { 
        //return lps(s.toCharArray(), 0, s.length()-1); time limit
        
        int len = s.length();
        int [][] arr = new int [len][len];
    
        /*
        for(int i = len -1; i >= 0; i--) {
            arr[i][i] = 1;
            for(int j = i +1 ; j< len; j++) {
                if(s.charAt(i) == s.charAt(j))
                    arr[i][j] = arr[i+1][j-1] + 2;
                else
                    arr[i][j] = Math.max(arr[i][j-1], arr[i+1][j]);
            } 
        }*/
        
        for(int i = 0; i < len; i++) {
            arr[i][i] = 1;
            for(int j= i-1; j >= 0; j--) {
                if(s.charAt(i) == s.charAt(j))
                    arr[j][i] = arr[j+1][i-1] + 2;
                else
                    arr[j][i] = Math.max(arr[j][i-1], arr[j+1][i]);
            }
        }
        
        
        return arr[0][len-1];
    }
}