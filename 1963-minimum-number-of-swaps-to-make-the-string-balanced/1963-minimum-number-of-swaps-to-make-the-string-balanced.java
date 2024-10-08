class Solution {
    //solution 1
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()) {
            if(st.isEmpty() == false && c==']') {
                st.pop();
            } else if (c == '[')
                st.push(c);
        }
        
        return (st.size()+1)/2;
    }
}