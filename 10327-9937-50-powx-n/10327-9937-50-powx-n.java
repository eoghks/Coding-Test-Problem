class Solution {
    public double myPow(double x, int n) {
        return solution(x, (long)n);
    }

    private double solution(double x, long n) {
        if(n==0)
            return 1;
        if(n<0)
            return 1.0/solution(x, -n);
        if(n%2==0)
            return solution(x*x, n/2);
        return x*solution(x*x, (n-1)/2);
    }
}