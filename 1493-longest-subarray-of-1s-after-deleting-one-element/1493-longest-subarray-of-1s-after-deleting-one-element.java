class Solution {
    public int longestSubarray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int result = 0;
        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 ){
                list.add(cnt);
                cnt = 0;
            } else if( nums.length-1 == i) {
                list.add(++cnt);
            }
            else {
                cnt++;
            }
                
        }
        if(list.size() == 1 && list.get(0) != 0) 
            result = list.get(0) -1;
        else{
            for(int i = 0; i < list.size() - 1; i++) {
                if(list.get(i) + list.get(i+1) > result) {
                    result = list.get(i) + list.get(i+1);
                }
            }
        }
        
        return result;
    }
}