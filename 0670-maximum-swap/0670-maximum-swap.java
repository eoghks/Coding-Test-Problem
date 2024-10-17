class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        char[] c = s.toCharArray();
        int i = 1;
        while(i<c.length) {
            if(c[i-1] <c[i])
                break;
            i++;
        }
        
        if(i<c.length) {
            int j = i;
            for(int k =j+1; k<c.length; k++) {
                if(c[j] <= c[k])
                    j = k;
            }
            
            for(int k=0; k<i; k++) {
                if(c[k] <c[j]) {
                    char temp = c[k];
                    c[k] = c[j];
                    c[j] = temp;
                    break;
                }
            }
            num = Integer.parseInt(new String(c));
        }
            
        return num;
    }
}