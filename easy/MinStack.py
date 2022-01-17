class MinStack(object):
    
    def __init__(self):
        #self.idx=-1
        self.list1=[]

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.list1.append(val)
        #self.idx+=1

    def pop(self):
        """
        :rtype: None
        """
        self.list1.pop()
        #self.idx-=1
        

    def top(self):
        """
        :rtype: int
        """
        return self.list1[-1]

    def getMin(self):
        """
        :rtype: int
        """
        '''min=self.list1[0]
        for i in self.list1[1:]:
            if(i<min):
                min=i'''
        return min(self.list1)


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()