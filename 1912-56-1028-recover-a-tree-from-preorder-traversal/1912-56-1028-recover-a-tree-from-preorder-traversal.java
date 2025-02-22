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
    //idx는 
    private String s;
    private int idx = 0;
    private int level = 0;

    public TreeNode recoverFromPreorder(String traversal) {
        this.s = traversal;
        TreeNode node = new TreeNode(-1);
        this.helper(node, 0);
        return node.left;
    }

    private void helper(TreeNode parent, int lvl) {
        //DFS 방식
        //lvl은 현재 깊이, level은 현재 숫자의 깊이(-의 갯수)
        while (this.idx < this.s.length() && lvl == level) {
            int num = 0;
            //일의자리 숫자보다 큰 경우를 대비하여 while문
            while (this.idx < this.s.length() && Character.isDigit(this.s.charAt(this.idx))) {
                num = num * 10 + (this.s.charAt(this.idx++) - '0');
            }
            TreeNode node = new TreeNode(num);
            //자식이 하나인 경우 왼쪽에 존재
            if (parent.left == null)
                parent.left = node;
            else
                parent.right = node;
            
            this.level = 0;
            //다음 depth 판단
            while (this.idx < this.s.length() && this.s.charAt(this.idx) == '-') {
                this.level++;
                this.idx++;
            }
            this.helper(node, lvl + 1);
        }
    }
}