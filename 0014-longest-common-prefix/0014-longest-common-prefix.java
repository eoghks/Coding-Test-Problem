class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length ==1)
            return strs[0];

        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length-1];
        for(int i=0; i<str1.length() && i<str2.length(); i++) {
            if(str1.charAt(i) == str2.charAt(i))
                sb.append(str1.charAt(i));
            else
                break;
        }
        return sb.toString();
    }
}