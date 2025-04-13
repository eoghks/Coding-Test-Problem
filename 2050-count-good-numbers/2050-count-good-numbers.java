class Solution {
    //5^evenPos*4^oddPos
    //n=4일때, 5^2*4^2 = 25* 16
    final int MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long evenPos = (n+1)/2;
        long oddPos = n/2;
        long even = solution(5, evenPos);//0 2 4 6 8-> 5개
        long odd = solution(4, oddPos);//2 3 5 7 -> 4개
        return (int)((even*odd)%MOD);
    }

    long solution(long base, long pos) {
        long res = 1;
        while(pos>0) {
            //pos가 홀수 이므로 짝수로 맞추기
            if(pos%2==1) {
                res = (res*base) % MOD;
            }
            // 지수를 절반으로 줄이고, base를 제곱
            // 5^4 == 25^2
            base = (base*base) %MOD;
            pos /= 2;
        }
        return res;
    }
}