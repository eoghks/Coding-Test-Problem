class Solution {
    //n=1 -> 1
    //n=2 -> 1 + 4
    //n=3 -> 1 + 4 + 8
    //n=4 -> 1 + 4 + 8 + 12
    //n=i -> 1 + 4(1+2+...+i)
    //=> 1 + 4*(n*(n-1)/2)
    //=> 2*n*(n-1)+1
    public long coloredCells(int n) {
        return 2L*n*(n-1)+1;
    }
}