class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();
        Arrays.sort(words, (s1, s2)-> s1.length()-s2.length());
        for(int i=0; i<words.length; i++) {
            for(int j=i+1; j<words.length; j++) {
                if(words[j].contains(words[i])) {
                    list.add(words[i]);
                    break;
                }     
            }
        }

        return list;
    }
}