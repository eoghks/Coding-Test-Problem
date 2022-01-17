class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        majority=len(nums)/2
        num=set(nums)
        for i in num:
            if(nums.count(i)>majority):
                return i