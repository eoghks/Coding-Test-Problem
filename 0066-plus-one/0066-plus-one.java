class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        //기존 자릿수가 모두 1이고 올림수가 1이 남앗다.
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}