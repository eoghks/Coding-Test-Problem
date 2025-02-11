class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder res = new StringBuilder();
        int n = part.length();
        for (char c : s.toCharArray()) {
            res.append(c);
            if (res.length() >= n && res.substring(res.length() - n).equals(part)) {
                res.delete(res.length() - n, res.length());
            }
        }
        return res.toString();
    }
}