class Solution {
    public long minimumSteps(String s) {
        long cnt = 0;
        char[] c = s.toCharArray();
        int n = c.length;
        int cnt1 = 0;
        
        for(int i=n-1; i>=0; i--) {
            if(c[i] == '1') {
                cnt += (n-cnt1-i-1);
                cnt1++;
            }
        }
        
        return cnt;
    }
}