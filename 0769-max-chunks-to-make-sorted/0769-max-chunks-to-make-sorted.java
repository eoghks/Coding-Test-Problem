class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] max = new int[arr.length];
        max[0] = arr[0];
        for(int i=1; i<arr.length; i++) {
            max[i] = Math.max(max[i-1], arr[i]);
        }
        
        int cnt = 0;
        for(int i=0; i<arr.length; i++) {
            if(max[i] == i)
                cnt++;
        }
        return cnt;
    }
}