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
                    return false;
                }
            }
        }

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