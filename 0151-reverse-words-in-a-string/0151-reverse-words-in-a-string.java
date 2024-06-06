class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = words.length - 1; i > -1; i--) {
            if(words[i].equals("") == false)
                result.append(words[i] + " ");
        } 
        return result.toString().trim();
    }
}