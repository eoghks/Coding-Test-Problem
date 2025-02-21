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
class FindElements {
    Set<Integer> set = new HashSet<>();
    public FindElements(TreeNode root) {
        root.val = 0;
        recover(root);
    }
    
     private void recover(TreeNode root) {
        if (root == null)
            return;
        set.add(root.val);
        if (root.left != null) {
            root.left.val = 2 * root.val + 1;
            recover(root.left);
        }
        if (root.right != null) {
            root.right.val = 2 * root.val + 2;
            recover(root.right);
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */