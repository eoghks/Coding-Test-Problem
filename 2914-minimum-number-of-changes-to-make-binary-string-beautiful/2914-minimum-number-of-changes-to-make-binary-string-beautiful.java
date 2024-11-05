class Solution {
    public int minChanges(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int one = 0;
        int zero = 0;
        for(int i=0; i<n; i++) {
            if(c[i] == '1') {
                one++;
            } else {
                zero++;
            }
        }
        
        if(one == 0 || zero == 0) {
            return 0;
        }
        
        int i =0;
        int j = 1;
        int cnt = 0;
        while(j < n) {
            if(c[i] != c[j]) {
                cnt++;
            }
            i+=2;
            j+=2;
        }
        return cnt;
    }
}