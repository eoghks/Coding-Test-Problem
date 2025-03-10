class Solution {
    //길이가 k개이상에서 k+1 이상을 빼면 정확히 k개인 substring
    public long countOfSubstrings(String word, int k) {
        return solution(word, k) - solution(word, k + 1);
    }
     private long solution(String word, int k) {
        int n = word.length();
        long res = 0;
        int consonants = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char c = word.charAt(right);
            if (isVowel(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            } else {
                consonants++;
            }
            //5개의 모음이 존재하고 자음이 k개 이상인 경우
            while (map.size() == 5 && consonants >= k) {
                res += n - right;
                char leftChar = word.charAt(left);
                if (isVowel(leftChar)) {
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }
                } else {
                    consonants--;
                }
                left++;
            }
        }
        return res;
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}