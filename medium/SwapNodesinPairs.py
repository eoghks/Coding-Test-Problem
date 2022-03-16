# Definition for singly-linked list.
class ListNode(object):
     def __init__(self, val=0, next=None):
         self.val = val
         self.next = next
class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        
        #val 값을 바꿔주는 방법
        '''
        #head가 None이거나 head.next가 None라 바꿀게 없는경우
        if not head or not head.next:
            return head
        
        h=head.next
        #값 바꾸기
        temp=head.val
        head.val=h.val
        h.val=temp
        h=h.next
        
        #h=head.next.next -> h에 대하여 다시 swap 시전
        self.swapPairs(h)
        #head값 반환
        return head
        '''
        #next를 바꿔주는 방법 
        if head is None:
            return head
        sentinel = ListNode(-1, head)
        pre, node1, node2 = sentinel, head, head.next
        while node2 is not None:
            pre.next = node2
            suc = node2.next
            node1.next = node2.next
            node2.next = node1
            if suc is not None:
                pre, node1, node2 = node1, suc, suc.next
            else:
                break
        return sentinel.next
        

