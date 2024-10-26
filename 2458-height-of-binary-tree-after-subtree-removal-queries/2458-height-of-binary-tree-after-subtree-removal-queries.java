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
    private Map<Integer, Integer> leftMap = new HashMap<>();
    private Map<Integer, Integer> rightMap = new HashMap<>();
    private Map<Integer, Integer> removed = new HashMap<>();

    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] res = new int[queries.length];
        getHeight(root, 0);
        getRemoveHeight(root, 0);
        for(int i=0; i<queries.length; i++) {
            res[i] = removed.get(queries[i]);
        }
        return res;
    }
    
    //오른쪽 왼쪽을 지워가면 높이를 구한다. 
    private void getRemoveHeight(TreeNode node, int height) {
        if(node == null)
            return;
        removed.put(node.val, height);
        getRemoveHeight(node.left, Math.max(height, rightMap.get(node.val)));
        getRemoveHeight(node.right, Math.max(height, leftMap.get(node.val)));
    }
    
    
    private int getHeight(TreeNode node, int height) {
        if(node == null)
            return height -1;
        //왼쪽 서브트리의 높이를 구하기
        leftMap.put(node.val, getHeight(node.left, height +1));
        //오른쪽 서브트리의 높이를 구하기
        rightMap.put(node.val, getHeight(node.right, height +1));
        
        //더 높이가 높은 쪽의 서브트리의 높이가 나의 높이
        return Math.max(leftMap.get(node.val), rightMap.get(node.val));
    }
}