# Definition for singly-linked list.
class ListNode(object):
  def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        tailA=headA
        tailB=headB
        cntA, cntB=0,0
        #둘이 언젠가 만난다면 tail의 주소값이 같다.
        while( tailA):
            tailA=tailA.next
            cntA+=1
        
        while( tailB):
            tailB=tailB.next
            cntB+=1
        #따라서 tail의주소값이 틀리면 교집합은 없다.
        if(tailA!=tailB):
            return None
        #더긴 길이를 가진 head는 더 적은 길이를 가진 head부터 같을 확률이 있다. 길이 맞추기.
        if(cntA>cntB):
            for i in range(cntA-cntB):
                headA=headA.next
        else:
            for i in range(cntB-cntA):
                headB=headB.next
        #tail까지의 길이는 동일하므로 동시에 next를 해도 상관 없다!!
        while headA!=headB:
            headA=headA.next
            headB=headB.next
        
        return headA