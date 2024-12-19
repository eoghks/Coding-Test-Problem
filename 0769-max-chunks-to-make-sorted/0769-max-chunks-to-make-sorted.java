class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] max = new int[arr.length];
        //0 초기화
        max[0] = arr[0];
        //i까지 나온 최대 수를 구함
        for(int i=1; i<arr.length; i++) {
            max[i] = Math.max(max[i-1], arr[i]);
        }
        
        int cnt = 0;
        //max[i]가 i이라는건 0~i까지 0~i까지의 수가 존재한다는 의미
        for(int i=0; i<arr.length; i++) {
            if(max[i] == i)
                cnt++;
        }
        return cnt;
    }
}