import heapq as hq
class KthLargest(object):

    def __init__(self, k, nums):
        """
        :type k: int
        :type nums: List[int]
        """
        '''
        self.k=k
        self.nums=sorted(nums)
        '''
        self.k=k
        self.nums=nums
        hq.heapify(self.nums)

    def add(self, val):
        """
        :type val: int
        :rtype: int
        """
        '''
        self.nums.append(val)
        self.nums.sort()
        return self.nums[-self.k]
        '''
        hq.heappush(self.nums,val)
        #k가 3이라면 heap의 크기는 3으로 유지하면된다. 그이상은 필요없다. 
        # -> 만약 3번째로 큰수보다 작은수가 들어올경우 크기가 4로 되고 들어온수가 빠져서 heap 크기 3으로 유지
        # -> 큰수가 들어올경우 크기가 4로되어 원래 3번째로 큰수가 빠져나가 heap 크기 3으로 유지
        while(len(self.nums)>self.k):
            hq.heappop(self.nums)
        
        return self.nums[0]