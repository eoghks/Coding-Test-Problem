class Solution {
    public int twoEggDrop(int n) {
        int result = 1;
        n = n - 2 ; // 0층에서 한번 던졋을 때, 깨지면 0층 안깨지며 1층에서 깨진다는것을 알 수 있다.
        while(n >= 0) {// >=를 사용한 이뉴는 n층이라하지만 0층이 존재하여 실제로는 n+1층이 존재한다.
            result++;
            n -= result;
        }
        
        return result;
    }
}