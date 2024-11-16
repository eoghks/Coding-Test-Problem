class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res =  new int[n-k+1];
        int i=0;
        int j=k-1;
        int idx =0;
        while(j<n) {
            if(solved(nums, i, j)) {
                res[idx] = nums[j];
            } else {
                res[idx] = -1;
            }
            i++;
            j++;
            idx++;
        }
        return res;
    }
    
    private boolean solved(int nums[],int start,int end){
        for(int i=start;i<end;i++){
            if(nums[i]+1!=nums[i+1]){
                return false;
            }
        }
        return true;
    }
}