class Solution {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> st = new ArrayDeque<>();
        char[] chs = expression.toCharArray();
        for(char c: chs) {
            if(c==')') {
                Set<Character> set = new HashSet<>();
                while(st.peek() != '(')
                    set.add(st.pop());
                st.pop();
                char op = st.pop();
                if(op == '&') {
                    st.push(set.contains('f') ? 'f' : 't');
                } else if(op == '|') {
                    st.push(set.contains('t') ? 't' : 'f');
                } else {
                    st.push(set.contains('t') ? 'f' : 't');
                }
            } else if(c != ',') {
                st.push(c);
            }
        }
        return st.pop() =='t';
    }
}