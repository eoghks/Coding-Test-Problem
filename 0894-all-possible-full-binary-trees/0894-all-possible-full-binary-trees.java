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
        TreeNode root = new TreeNode();
        List<TreeNode> result = new ArrayList<>();
        if(n == 1){
            result.add(root);
            return result;
        }
        
        for(int i =1 ; i < n; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);
            for(TreeNode l: left) {
                for(TreeNode r: right) {
                    TreeNode cur = new TreeNode();
                    cur.left = l;
                    cur.right = r;
                    result.add(cur);
                }
            }
        }
        
        return result;
    }
}