class Solution {
    public int twoEggDrop(int n) {
        int result = 1;
        n = n - 2 ; //층 번던져서 3층까지 확인가능
        while(n >= 0) {
            result++;
            n -= result;
        }
        
        return result;
    }
}