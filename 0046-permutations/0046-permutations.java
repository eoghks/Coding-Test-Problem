class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res=new ArrayList<>();
        solution(new ArrayList<>(), nums);
        return res;
    }
    public void solution(List<Integer> list, int[] nums) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int num: nums) {
            if(list.contains(num) == false) {
                list.add(num);
                solution(list, nums);
                list.remove(list.size()-1);
            }
        }
    }
}