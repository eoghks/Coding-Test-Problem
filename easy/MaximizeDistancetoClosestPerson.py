class Solution(object):
    def maxDistToClosest(self, seats):
        """
        :type seats: List[int]
        :rtype: int
        """
        #각 끝에 앉을수 있는경우
        #두사람 사이에 앉아야하는 경우 2가지가 존재
        start, end, max, cur=-1, 0, 0, 0
        for i in range(len(seats)):
            if seats[i]==1:
                end=i
                if(start==-1):
                    cur=end
                else:
                    cur=(end-start)/2
                if(max<cur):
                    max=cur
                start=i
            elif(i==len(seats)-1):
                cur=i-start
                if(max<cur):
                    max=cur        
        return max