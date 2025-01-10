class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        int[] maxFreq = new int[26];

        for(String w: words2) {
             int[] curFreq = new int[26];
            for(char c: w.toCharArray()) {
                curFreq[c-'a']++;
            }

            for(int i=0; i<curFreq.length; i++) {
                maxFreq[i] = Math.max(maxFreq[i], curFreq[i]);
            }
        }

        for(String w: words1) {
            boolean isUniversal = true;
            int[] curFreq = new int[26];
            for(char c: w.toCharArray()) {
                curFreq[c-'a']++;
            }

            for(int i=0; i<curFreq.length; i++) {
                if(maxFreq[i] > curFreq[i]) {
                    isUniversal = false;
                    break;
                }
            }

            if(isUniversal)
                res.add(w);
        }
        return res;
    }
}