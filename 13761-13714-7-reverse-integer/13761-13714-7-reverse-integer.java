class Solution {
    public int reverse(int x) {
        int num = Math.abs(x);

        int res = 0;
        while (num != 0) {
            int remainder = num % 10;
            
            // 오버플로우res * 10 + remainder > Integer.MAX_VALUE
            // int형이기 때문에 이항해서 확인
            if (res > (Integer.MAX_VALUE - remainder) / 10) {
                return 0; 
            }
            
            res = res * 10 + remainder;  
            num = num / 10; 
        }

        return x<0? -res: res;
    }
}