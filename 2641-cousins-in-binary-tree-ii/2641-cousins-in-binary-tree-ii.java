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
    public TreeNode replaceValueInTree(TreeNode root) {
        root.val =0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(q.isEmpty() == false) {
            int len = q.size();
            int sum =0;
            List<TreeNode> temp = new ArrayList<>();
            
            for(int i =0; i<len; i++) {
                TreeNode n = q.remove();
                temp.add(n);
                
                if(n.left != null) {
                    sum+=n.left.val;
                    q.add(n.left);
                }
                
                if(n.right != null) {
                    sum+=n.right.val;
                    q.add(n.right);
                }
            }
            
            for(TreeNode n: temp) {
                int val = sum;
                
                if(n.left != null)
                    val -= n.left.val;
                if(n.right != null)
                    val -= n.right.val;
                
                if(n.left != null)
                    n.left.val = val;
                if(n.right != null)
                    n.right.val = val;
            }
        }
            
            
        return root;
    }
}