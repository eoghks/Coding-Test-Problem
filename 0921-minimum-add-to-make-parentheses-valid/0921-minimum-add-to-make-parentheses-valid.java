class Solution {
    public int minAddToMakeValid(String s) {
        int res = 0;
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c=='(') {
                st.push(c);
            } else if(st.isEmpty()){
                res++;
            } else {
                st.pop();
            }
        }
        return res+st.size();
    }
}