class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res=new ArrayList<>();
        //solution1(new ArrayList<>(), nums);
        solution2(nums, 0);
        return res;
    }
    
    public void solution1(List<Integer> list, int[] nums) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int num: nums) {
            if(list.contains(num) == false) {
                list.add(num);
                solution1(list, nums);
                list.remove(list.size()-1);
            }
        }
    }
    
     public void solution2(int[] nums, int st) {
        if(st == nums.length-1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
            return;
        }
        
        for(int i=st; i<nums.length; i++) {
            swap(nums, st, i);
            solution2(nums, st+1);
            swap(nums, st, i);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}