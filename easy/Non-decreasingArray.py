class Solution(object):
    def checkPossibility(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        #최대 하나의 원소를 수정하여 오름차순을 만들수 있냐
        #내림차순인 배열구하기
        if( len(nums)<2):
            return True
        
        count=0
        
        for i in range(1, len(nums)):
            if(nums[i-1]>nums[i]):
                count+=1
                
                if( i==1 or nums[i-2] <=nums[i]):
                    nums[i-1]=nums[i]
                else:
                    nums[i]=nums[i-1]
                
                if count>1:
                    return False
        
        return True