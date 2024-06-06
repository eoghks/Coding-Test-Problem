class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for(String word: words) {
                result.insert(0, " "+ word);
        } 
        return result.toString().trim();
    }
}