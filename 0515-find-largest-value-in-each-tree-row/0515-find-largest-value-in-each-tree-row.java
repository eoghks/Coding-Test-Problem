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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
            return res;
        
        //add Root
        q.add(root);
        //Queue가 비엇다는건 leaf node까지 확인을 했다는 의미이다.
        while(!q.isEmpty()) {
            int max = q.peek().val;
            //기존의 요소 수만큼만 반복하도록
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode node = q.remove();
                max = Math.max(max, node.val);
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            res.add(max);
        }
        return res;
    }
}