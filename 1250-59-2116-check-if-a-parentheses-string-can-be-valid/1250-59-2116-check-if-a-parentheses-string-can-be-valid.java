class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2 ==1) 
            return false;
        
        Stack<Integer> open = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(locked.charAt(i) == '0')
                unlocked.push(i);
            else if (s.charAt(i) == '(') 
                open.push(i);
            else if (s.charAt(i) == ')') {
                if (!open.empty()) {
                    open.pop();
                } else if (!unlocked.empty()) {
                    unlocked.pop();
                } else {
                    //열린 괄호가 없고 바꿀수 있는 부분이 없다는 것은 valid하지 않다는 의미
                    return false;
                }
            }
        }

        //open.peek() < unlocked.peek()
        //열린 괄호보다 뒤에 닫을 괄호가 필요하다. 따라서 unlokced의 index가 더 커야 가능하다.
        while(!open.empty() && !unlocked.empty() && open.peek() < unlocked.peek()) {
            open.pop();
            unlocked.pop();
        }

        if(!open.empty()) {
            return false;
        }
        return true;
    }
}