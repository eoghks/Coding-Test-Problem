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
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for(int i=0; i<n; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, n - 1, postorder, 0, n- 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);

        int left = rootIndex - inStart;
        int right = inEnd - rootIndex;
        root.left = buildTree(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + left - 1);
        root.right = buildTree(inorder, rootIndex + 1, inEnd, postorder, postEnd - right, postEnd - 1);
        return root;
    }
}