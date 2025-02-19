class Solution {
    private char[] chars = {'a', 'b', 'c'};
    private String res = "";
    int cnt = 0;
    public String getHappyString(int n, int k) {
        cnt = k;
        solution(0, n, new StringBuilder());
        return res;
    }

    private void solution(int len, int n, StringBuilder sb) {
        if (len == n) {
            if (--cnt == 0) {
                res = sb.toString();
            }
            return;
        }
        for (char c : chars) {
            if (len == 0 || sb.charAt(len - 1) != c) {
                sb.append(c);
                solution(len + 1, n, sb);
                sb.deleteCharAt(sb.length() - 1);
                if (cnt == 0) 
                    return; 
            }
        }
    }
}