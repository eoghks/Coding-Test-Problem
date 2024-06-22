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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
         if(root != null) {
             indorder(root, result);
         }
                
        return result ;
    }
    
    public void indorder(TreeNode root, List<Integer> list) {
        if(root.left != null)
            indorder(root.left, list);
        list.add(root.val);
        if(root.right != null )
            indorder(root.right, list);  
    }
}