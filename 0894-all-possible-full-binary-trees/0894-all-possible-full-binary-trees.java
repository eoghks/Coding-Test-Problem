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
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        List<TreeNode> first = new ArrayList<>();
        first.add(new TreeNode());
        map.put(1, first);
        
        for(int i = 3; i <= n; i += 2) {
            List<TreeNode> temp = new ArrayList<>();
            for(int j = 1; j < i; j += 2) {
                List<TreeNode> left = map.get(j);
                List<TreeNode> right = map.get(i - j -1);
                for(TreeNode l: left) {
                    for(TreeNode r: right) {
                        TreeNode node = new TreeNode();
                        node.left = l;
                        node.right = r;
                        temp.add(node);
                    }
                }
            }
            map.put(i, temp);
        }

        return map.get(n);
    }
}