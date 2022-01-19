class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        maxsum=0
        last=0
        
        for i in nums:
            lastmax=maxsum
            maxsum=max(last+i, maxsum)
            last=lastmax
        
        return maxsum