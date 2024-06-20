class Solution {
    public int findMaxLength(int[] nums) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum =0;
        map.put(0, -1);
        
        for(int i=0; i<nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1;
            if(map.containsKey(sum)  == false)
                map.put(sum, i);
            else
                max = Math.max(max, i - map.get(sum)); 
            
        }
        
        return max;
    }
}