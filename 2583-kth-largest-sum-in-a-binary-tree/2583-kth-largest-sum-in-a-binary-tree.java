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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> sums = new PriorityQueue<>((a,b) -> Long.compare(b, a));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            long sum = 0;
            for(int i=0;i<size;i++) {
                TreeNode cur = q.remove();
                sum += cur.val;
                if(cur.left != null)
                    q.add(cur.left);
                if(cur.right != null)
                    q.add(cur.right);
            }
            sums.add(sum);
        }
        
        while(sums.isEmpty() == false && k > 1) {
            System.out.println(sums.remove());
            k--;
        }
        return sums.isEmpty() ? -1 : sums.peek();
    }
}