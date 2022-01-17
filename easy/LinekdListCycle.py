# Definition for singly-linked list.
#class ListNode(object):
def __init__(self, x):        
    self.val = x
    self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        '''
        idlist=[id(head)]
        result=False
        
        if(head==None):
            return result
        
        while(head.next!= None):
            head=head.next
            if(idlist.count(id(head)) == 0):
                idlist.append(id(head))
            else:
                result=True
                break
        
        return result
        '''
        #두칸씩 이동하는 first가 next와 nextnext가 None면 cycle이없다
        #그러나 cycle이 있다면 언젠가 first와 second가 만나게된다. 
        #이방식이 속도가 더 빠르다
        if not head:
            return False
        if not head.next:
            return False
        
        first = head
        second = head
        while first != None and first.next != None:
            first = first.next.next
            second = second.next
            if first == second:
                return True
        return False
        
        