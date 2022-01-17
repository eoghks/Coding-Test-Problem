class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        result=[]
        for i in range(len(nums)):
            check=False
            for j in range (i+1,len(nums)):
                if(nums[i]+nums[j]==target):
                    result.append(i)
                    result.append(j)
                    check=True
                    break
            if(check):
                    break
        
        return result