class Solution {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] check; 
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        check = new boolean[nums.length];
        solution(nums, new ArrayList<>());
        return res;
    }
    
    public void solution(int[] nums, List<Integer> list) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(check[i] || (i > 0 && nums[i] == nums[i-1] && check[i-1])) {
                continue;
            }
            list.add(nums[i]);
            check[i] = true;
            solution(nums, list);
            list.remove(list.size()-1);
            check[i] = false;
        }
    }
}