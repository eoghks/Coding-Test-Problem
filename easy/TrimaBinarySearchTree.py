# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def trimBST(self, root, low, high):
        """
        :type root: TreeNode
        :type low: int
        :type high: int
        :rtype: TreeNode
        """
        '''
        if not root:
            return
        root.left=self.trimBST(root.left, low, high)
        root.right=self.trimBST(root.right, low, high)
        print(root)
        if low<=root.val and high>=root.val :
            return root
        else:
            if not root.left and not root.right:
                return 
            if not root.left:
                return root.right
            else:
                return root.left
        '''
        #binary tree는 왼쪽 노드가 현재노드보다 작고 오른쪽 노드가 현재노드보다 크다 이점을 생각하여 다시코딩
        '''
        if not root:
            return
        if low>root.val:
            return self.trimBST(root.right, low, high)
        if high<root.val:
            return self.trimBST(root.left, low, high)
        root.left=self.trimBST(root.left, low, high)
        root.right=self.trimBST(root.right, low, high)
        return root
        '''
        #함수를 단순화 + 함수안에 함수 생성
        def trim(root):
            if not root:
                return
            elif low>root.val:
                return trim(root.right)
            elif root.val>high:
                return trim(root.left)
            else:
                root.left=trim(root.left)
                root.right=trim(root.right)
                return root
        return trim(root)