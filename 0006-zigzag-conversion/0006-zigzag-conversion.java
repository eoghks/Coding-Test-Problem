class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++) {
            sb[i] = new StringBuilder();
        }

        char[] c = s.toCharArray();
        int idx = 0;
        int len = s.length();
        while(idx < len) {
            //up
            for(int i=0; i<numRows && idx<len; i++) {
                sb[i].append(c[idx++]);
            }
            //down
            for(int i=numRows-2; i>=1 && idx<len; i--) {
                sb[i].append(c[idx++]);
            }
        }
        
        for(int i=1; i<numRows; i++) {
            sb[0].append(sb[i].toString()); 
        }
        return sb[0].toString();
    }
}