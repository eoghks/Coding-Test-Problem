class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        int[] sortArr = new int[n];
        for(int i=0; i<nums.length; i++) {
            sortArr[i] = nums[i];
        }
        Arrays.sort(sortArr);

        HashMap<Integer, Integer> group = new HashMap<>();
        HashMap<Integer, LinkedList<Integer>>member = new HashMap<>();
        int key = 0; 
    
        group.put(sortArr[0], key);
        member.put(key, new LinkedList<Integer>(Arrays.asList(sortArr[0])));

        for(int i=1; i<n; i++) {
            if(Math.abs(sortArr[i]-sortArr[i-1])>limit)
                key++;
            group.put(sortArr[i], key);
            
            if(!member.containsKey(key))
                member.put(key, new LinkedList<Integer>());

            member.get(key).add(sortArr[i]);
        }
        for(int i=0; i<n; i++) {
            int cur = nums[i];
            int groupNum = group.get(cur);
            nums[i] = member.get(groupNum).pop();
        }
        return nums; 
    }
}