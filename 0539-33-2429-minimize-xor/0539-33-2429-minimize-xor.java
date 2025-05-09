class Solution {
    public int minimizeXor(int num1, int num2) {
        int countBit = 0;
        int temp = num2;
        while(temp >0) {
            if(temp%2==1)
                countBit++;
            temp>>=1;
        }
        int res =0;
        //1인부분 앞에서부터 먼저 채우기
        for(int i =31; i>=0 && countBit > 0; i--) {
            if((num1 & (1<<i)) != 0) {
                res |= (1 << i);
                countBit--;
            }
        }
        //1이 남앗다면 뒤에서부터 채우기
        for(int i =0; i<32 && countBit > 0; i++) {
            if((res & (1<<i)) == 0) {
                res = res | (1<<i);
                countBit--;
            }
        }

        return res;
    }
}