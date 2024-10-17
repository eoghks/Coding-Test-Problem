class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        char[] c = s.toCharArray();
        int i = 1;
        //내림차순이 아닌부분찾기
        while(i<c.length) {
            if(c[i-1] <c[i])
                break;
            i++;
        }
        
        if(i<c.length) {
            int j = i;
            // 뒤에서 최대값의 인덱스찾기
            for(int k =j+1; k<c.length; k++) {
                if(c[j] <= c[k])
                    j = k;
            }
            
            //뒤에서 최대값 보다 작은 교환할 값의 인덱스 찾아 바꾸기
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