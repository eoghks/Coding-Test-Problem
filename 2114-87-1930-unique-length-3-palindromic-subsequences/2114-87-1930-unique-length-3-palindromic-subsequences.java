class Solution {
    public int countPalindromicSubsequence(String s) {
        int[][] arr = new int[26][2];
        char[] c = s.toCharArray();
        for(int[] a: arr) {
            Arrays.fill(a, -1);
        }
        for(int i=0; i<s.length(); i++) {
            int[] alp = arr[c[i]-'a'];
            if(alp[0] == -1)
                alp[0] = i;
            else
                alp[1] = i;
        }
        
        int res = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i][0] != -1 && arr[i][1] != -1) {
                Set<Character> set = new HashSet<>();
                for(int j=arr[i][0]+1; j<arr[i][1]; j++) {
                    set.add(c[j]);
                }
                res+=set.size();
            }
        }
        return res;
    }
}