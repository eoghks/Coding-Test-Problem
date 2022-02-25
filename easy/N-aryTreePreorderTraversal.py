"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution(object):
    def preorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        def order(root):
            if not root:
                return
            result.append(root.val)
            for i in root.children :
                order(i)
        result=[]
        order(root)
        return result