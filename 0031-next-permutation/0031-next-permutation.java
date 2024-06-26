class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        
        if(i >= 0) {
            int j = nums.length-1;
            //nums[i]보다 큰 요소 중 처음 찾기(내림 차순으로 되어 있기때문에 처음으로 큰애가 큰애중 제일 작은애)
            while(j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            swap(nums,i, j);
        }
        
        changeAsc(nums, i+1);
    }
    
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void changeAsc(int[] nums,int start){
        int end = nums.length-1;
        while(start < end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
}