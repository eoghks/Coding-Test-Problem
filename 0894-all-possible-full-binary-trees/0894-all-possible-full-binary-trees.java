/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2 == 0) {
            return new ArrayList<>();
        }
        List<List<TreeNode>> dp = new ArrayList<List<TreeNode>>();
        //Map<Integer, List<TreeNode>> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            dp.add(i, new ArrayList<TreeNode>());
        }
        //List<TreeNode> first = new ArrayList<>();
        //first.add(new TreeNode());
        //map.put(1, first);
        dp.get(1).add(new TreeNode(0));
        
        for(int i = 3; i <= n; i += 2) {
            List<TreeNode> temp = dp.get(i);
            for(int j = 1; j < i; j += 2) {
                List<TreeNode> left = dp.get(j);
                List<TreeNode> right = dp.get(i - j -1);
                for(TreeNode l: left) {
                    for(TreeNode r: right) {
                        TreeNode node = new TreeNode();
                        node.left = l;
                        node.right = r;
                        temp.add(node);
                    }
                }
            }
            
            //map.put(i, temp);
        }

        return dp.get(n);
    }
}