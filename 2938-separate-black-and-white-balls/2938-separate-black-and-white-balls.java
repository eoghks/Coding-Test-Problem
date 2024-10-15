class Solution {
    char[] c;
    /*
    public long minimumSteps(String s) {
        long cnt = 0;
        c = s.toCharArray();
        int n = c.length;
        int cnt1 = 0;
        
        for(int i=n-1; i>=0; i--) {
            if(c[i] == '1') {
                cnt += (n-cnt1-i-1);
                cnt1++;
            }
        }
        
        return cnt;
    }*/
    
    public long minimumSteps(String s) {
        long cnt = 0;
        c = s.toCharArray();
        int n = c.length;
        int l = findLeft(0);
        int r = findRight(n-1);
        
        
        while(l<r) {
            cnt+=r-l;
            l = findLeft(l+1);
            r = findRight(r-1);
        }
         
        return cnt;
    }
    
    public int findLeft(int l) {
        while(l<c.length) {
            if(c[l] == '1')
                break;
            l++;
        }
        return l;
    }
    
    public int findRight(int r) {
        while(r>=0) {
            if(c[r] == '0')
                break;
            r--;
        }
        return r;
    }
}