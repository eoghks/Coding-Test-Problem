class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] cnts = new int[k];
        for(int num: arr) {
            num%=k;
            if(num<0)
                num+=k;
            cnts[num]++;
        }
        
        if(cnts[0]%2 != 0)
            return false;
        for(int i=1; i<=k/2; i++) {
            if(cnts[i] != cnts[k-i])
                return false;
        }
        return true;
    }
}