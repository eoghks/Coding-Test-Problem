class Solution {
    StringBuilder sb = new StringBuilder();
    public String intToRoman(int num) {
        int[] arr = new int[4];
        for(int i=3; i>=0; i--) {
            arr[i] = num%10;
            num/=10;
        }
        forAppend(arr[0], "M");
        digit(arr[1],"C", "D", "M");
        digit(arr[2],"X", "L", "C");
        digit(arr[3],"I", "V", "X");
        return sb.toString();
    }
    
    public void digit(int n, String one, String five, String ten) {
        if(n==9) {
            sb.append(one + ten);
        } else if(n==4) {
            sb.append(one + five);
        } else {
            if(n>=5) {
                sb.append(five);
                n%=5;
            }
            forAppend(n, one);
        }
    }
    
    public void forAppend(int n, String s) {
        for(int i=0; i<n; i++) {
            sb.append(s);
        }
    }
}