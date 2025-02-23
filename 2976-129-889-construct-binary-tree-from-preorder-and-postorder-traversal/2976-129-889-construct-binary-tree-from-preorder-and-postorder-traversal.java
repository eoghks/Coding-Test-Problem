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
    int index = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return construct(preorder, postorder, 0, postorder.length-1);
    }
    //preorder root -> left -> right
    //postorder는 left -> right -> root
    //따라서 left를 찾으면 postorder에서 right를 찾을 수 있다.
    private TreeNode construct(int[] preorder, int[] postorder, int l, int h) {
        if(index >= preorder.length || l > h) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index]);
        index++;
        if(l==h)
            return root;
        int i = l;
        //right를 찾는 코드
        for(; i<=h; i++) {
            if(postorder[i] == preorder[index])
                break;
        }
        if(l <= h) {
            root.left = construct(preorder, postorder, l, i);
            root.right = construct(preorder, postorder, i + 1, h - 1);
        }
        return root;
    }
}