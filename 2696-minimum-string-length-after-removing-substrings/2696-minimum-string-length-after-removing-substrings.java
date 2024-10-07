class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        st.push(s.charAt(0));
        for(int i=1;i<n;i++)
        {
            if(!st.isEmpty()&&((s.charAt(i)=='B'&&st.peek()=='A')||(s.charAt(i)=='D'&&st.peek()=='C')))
            {
                st.pop();
            }
            else
                st.push(s.charAt(i));
        }
        return st.size();
        /*
        //stack에 이전 char 문자를 기억해가면서 현재 문자와 비교
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(stack.isEmpty() == false &&((stack.peek()=='A'&& c=='B') || (stack.peek()=='C'&&c=='D')))
                stack.pop();
            else
                stack.push(c);
        }
        //stack에 남은 문자 수 반환
        return stack.size();*/
    }
}