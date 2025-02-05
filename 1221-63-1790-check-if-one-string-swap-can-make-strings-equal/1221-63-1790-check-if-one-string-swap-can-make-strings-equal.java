class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2))
            return true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int cnt = 0;
        int i = -1;
        int j = -1;
        for(int k=0; k<c1.length; k++) {
            if(c1[k] != c2[k]) {
                cnt++;
                if(i==-1)
                    i = k;
                else
                    j = k;
            }
        }
        if(cnt == 2 && c1[i] == c2[j] && c1[j] == c2[i]) {
            return true;
        }
        return false;
        
    }
}