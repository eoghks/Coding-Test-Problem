class Solution {
    public int numTilePossibilities(String tiles) {
        int[] alp = new int[26];
        for(char c: tiles.toCharArray()) {
            alp[c - 'A']++;
        }
        return backtrack(alp);
    }

    private int backtrack(int[] alp) {
        int count = 0 ;
        for(int i=0; i<26; i++) {
            if(alp[i] > 0) {
                alp[i]--;
                count+= 1+ backtrack(alp);
                alp[i]++;
            }
        }
        return count;
    }
}