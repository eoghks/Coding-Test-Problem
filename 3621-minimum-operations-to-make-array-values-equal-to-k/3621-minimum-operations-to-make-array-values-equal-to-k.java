class Solution {
    //제일 큰 숫자보다 작은 수를 h로 선택
    //set = 5,4,2 k=2 이면, 4,2 선택 -> 2번
    //set = 5,4,2 k=1 이면, 4,2,1 선택 -> 3번
    //따라서 k==min이면 set.size()-1, k!=min이면 set.size()
    public int minOperations(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            min = Math.min(min, num);
            set.add(num);
        }
        if(min < k)
            return -1;
        return set.size() - (min==k? 1:0);
    }
}