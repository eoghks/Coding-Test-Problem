class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        '''
        check=[True]*(len(nums)+1)
        check[0]=False
        num=set(nums)
        for i in num:
            check[i]=False
        
        result =[]
        
        
        for j in range(len(check)) :
            if(check[j]==True):
                result.append(j)
        
        return result
        '''
        a=set(range(1,len(nums)+1))
        result=list(a-set(nums))
        return result