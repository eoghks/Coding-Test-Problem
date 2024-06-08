class Solution {
    public int singleNumber(int[] nums) {
        Integer result = -1;
        List<Integer> list =Arrays.stream(nums).boxed().collect(Collectors.toList());
        for(Integer i: list) {
            if(Collections.frequency(list, i) == 1){
                result = i;
                break;
            }
        }
        
        return result.intValue();
    }
}