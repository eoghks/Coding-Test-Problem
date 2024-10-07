class Solution {
    public int minLength(String s) {
        //stack에 이전 문자를 기억해가면서 현재 문자와 비교
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(stack.isEmpty() == false &&((stack.peek()=='A'&& c=='B') || (stack.peek()=='C'&&c=='D')))
                stack.pop();
            else
                stack.push(c);
        }
        //stack에 남은 문자 수 반환
        return stack.size();
    }
}