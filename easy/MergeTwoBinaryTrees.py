# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def mergeTrees(self, root1, root2):
        """
        :type root1: TreeNode
        :type root2: TreeNode
        :rtype: TreeNode
        """
        if not root1 and not root2:
            return
        #한쪽이 null이때문에 아래는 다른 쪽 트리의 subtree를 그대로 가지면 간단하게 해결된다.!!
        if not root1:
            return root2
        if not root2:
            return root1
        new=TreeNode()
        new.val=root1.val+root2.val
        new.left=self.mergeTrees(root1.left, root2.left)
        new.right=self.mergeTrees(root1.right, root2.right)
        return new