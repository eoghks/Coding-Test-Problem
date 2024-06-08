class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i: nums) {
            //Integer num = new Integer(i);
            if(map.containsKey(i) ==true) {
                map.put(i, map.get(i) + 1);
                int count = map.get(i);
            } else {
                map.put(i, 1);
            }
        }
        System.out.println(map.size());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey().intValue();
            }
        }
        /*
        Integer result = -1;
        List<Integer> list =Arrays.stream(nums).boxed().collect(Collectors.toList());
        for(Integer i: list) {
            if(Collections.frequency(list, i) == 1){
                result = i;
                break;
            }
        }
        
        return result.intValue();*/
        return 0;
    }
}