class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if(k==0) 
            return res;
        
        int sum = 0;
        int end = k;
        int st = 1;
        
        if(k<0) {
            st = n + k;
            end = n - 1;
        }
        
        for(int i = st; i<=end; i++) {
            sum+=code[i];
        }
        
        for(int i=0; i< n; i++) {
            res[i] = sum;
            sum = sum - code[(st++) %n] + code[(++end) %n];
        }
        return res;
    }
}