class Solution {
    public int minimumLength(String s) {
        int[] alp = new int[26];
        int res =0;
        for(char c: s.toCharArray()) {
            alp[c-'a']++;
        }
        for(int a: alp) {
            if(a==0)
                continue;
            if(a%2==0) {
                res+=2;
            } else{
                res++;
            }
        }

        return res;
    }
}