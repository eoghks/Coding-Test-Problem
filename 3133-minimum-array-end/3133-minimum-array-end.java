class Solution {
    public long minEnd(int n, int x) {
        long res = x;
        while(n > 1) {
            res = (res+1) | x;
            n--;
        }
        return res;
    }
}