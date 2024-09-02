class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char[] chs = s.toCharArray();
        for(int i=0; i<chs.length/2; i++) {
            if(chs[i] != chs[chs.length-1-i])
                return false;
        }
        return true;
    }
}