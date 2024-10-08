class Solution {
    //(unbalance pairs +1) /2 ==> swap
    /*solution 1
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()) {
            if(st.isEmpty() == false && c==']') {
                st.pop();
            } else if (c == '[')
                st.push(c);
        }
        
        return (st.size()+1)/2;
    }*/
    /*solution 2*/
    public int minSwaps(String s) {
        int open = 0;
        for(char c: s.toCharArray()) {
            if(open > 0 && c==']') {
                open--;
            } else if (c == '[')
                open++;
        }
        
        return (open+1)/2;
    }
}