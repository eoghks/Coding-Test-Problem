class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];
        int left = boxes.charAt(0) == '1'? 1 : 0;
        int right = 0;
        for(int i=1; i<n; i++) {
            if(boxes.charAt(i) == '1') {
                right++;
                res[0] += i;
            }
        }     

        for(int i=1; i<n; i++) {
            res[i] = res[i-1] + left - right;
            if(boxes.charAt(i) == '1') {
                right --;
                left++;
            }
        }

        return res;
    }
}