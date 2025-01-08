class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int cnt = 0;
        for(int i=0; i<words.length-1; i++) {
            for(int j=i+1; j<words.length; j++) {
                if(words[j].startsWith(words[i]) && words[j].endsWith(words[i]))
                    cnt++;
            }
        }
        return cnt;
    }

    private boolean isPrefixSuffixPairs(String str1, String str2) {
        if(str2.startsWith(str1) && str2.endsWith(str1))
            return true;
        return false;
    }
}