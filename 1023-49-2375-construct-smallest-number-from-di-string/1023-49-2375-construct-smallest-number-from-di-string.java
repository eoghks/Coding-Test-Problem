class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        int top =0;
        int[]s = new int[10];
        s[0] = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            if(pattern.charAt(i) =='I') {
                while(top >=0)
                    sb.append(s[top--]);
            }
            s[++top] = i+2;
        }
        while(top >=0)
             sb.append(s[top--]);
        return sb.toString();
    }
}