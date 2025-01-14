class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        int[] temp = new int[n+1];
        int common = 0;
        for(int i=0; i<n; i++) {
            if(++temp[A[i]] == 2)
                common++;
            if(++temp[B[i]] == 2)
                common++;
            C[i] = common;
        }
        return C;
    }
}