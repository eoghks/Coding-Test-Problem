class Solution {
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for(String s: words) {
            if(s.startsWith(pref))
                res++;
        }
        return res;
    }
}