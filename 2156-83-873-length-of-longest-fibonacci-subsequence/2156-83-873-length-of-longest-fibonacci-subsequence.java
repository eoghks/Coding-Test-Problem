class Solution {
    //map에 원소를 넣고 확인하면서 진행
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(arr[i], i);
        }

        int max = 0;
        for(int i=0; i<n && max<n-i; i++) {
            for(int j=i+1; j<n; j++) {
                int cur = arr[j];
                int prev = arr[i];
                int len = 2;
                while(map.containsKey(cur+prev)) {
                    len++;
                    max = Math.max(max, len);
                    int temp = cur;
                    cur = cur+prev;
                    prev = temp;
                }
            }
        }

        return max;
    }
}