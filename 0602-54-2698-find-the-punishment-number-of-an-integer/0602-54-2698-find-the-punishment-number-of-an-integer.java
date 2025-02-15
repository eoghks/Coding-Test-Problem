class Solution {
    public int punishmentNumber(int n) {
        int res = 0;
        for(int i =1; i<=n; i++) {
            int cur = i*i;
            if(check(cur, i)) {
                res += cur;
            }
        }

        return res;
    }

    private boolean check(int cur, int i) {
        if(cur < i || i < 0)
            return false;
        if(cur == i)
            return true;
        return (check(cur/10, i-(cur%10)) || check(cur/100, i-(cur%100)) || check(cur/1000, i-(cur%1000)));
    }
}