class Solution(object):
    def findLengthOfLCIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        check=False
        max=1
        cnt=1
        for i in range(1,len(nums)):
            if(check):
                check=False
                cnt=1
            if(nums[i-1]<nums[i]):
                cnt+=1
            else:
                check=True
            if(max<cnt):
                max=cnt
        
        return max
            