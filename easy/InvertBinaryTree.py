# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        #재귀보다는 반복문이 더 빠르게 해결된다.
        '''
        if(root==None):
            return root
        if(root.left!= None):
            self.invertTree(root.left)
        if(root.right!=None):
            self.invertTree(root.right)
        root.right, root.left=root.left, root.right
        return root
        '''
        stack=[root]
        
        while stack:
            node=stack.pop()
            if node:
                node.right, node.left=node.left, node.right
                #2개를 +=하니 list가 되고 list+연산으로 하나의 list가 만들어진다.
                stack += node.left, node.right
            print(stack)
        return root
        