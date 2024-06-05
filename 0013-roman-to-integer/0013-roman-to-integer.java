class Solution {
    public int romanToInt(String s) {
        int result = 0; 

        for(int i=0; i <s.length(); i++) {
            int cur = convertInt(s.charAt(i));
            if(i == s.length()-1){
                result += cur;
                break;
            }
            
            int next = convertInt(s.charAt(i + 1));
            if (cur < next) {
                result -= cur;
            } else {
                result += cur;
            }
        }

        return result;
    }

    public int convertInt(char ch) {
        if(ch == 'I') {
            return 1; 
        } else if(ch == 'V') {
            return 5; 
        } else if(ch == 'X') {
            return 10; 
        } else if(ch == 'L') {
            return 50; 
        } else if(ch == 'C') {
            return 100; 
        } else if(ch == 'D') {
            return 500; 
        } else if(ch == 'M') {
            return 1000; 
        } else {
            return 0;
        }
    }
}