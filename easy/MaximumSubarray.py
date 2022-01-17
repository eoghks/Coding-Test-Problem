class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        '''
        #완전한 dyanmic=> time over
        sums=[]
        #subarray의 길이가 1
        for i in range(len(nums)):
            sums.append([nums[i]])
        #subarray의 길이가 2이상
        #i : subarray의 길이로 활용
        for i in range (2,len(nums)+1):
            #j : 시작 index로 활용 
            for j in range(len(nums)-i+1):
                sum=sums[j][i-2]+nums[j+i-1]
                sums[j].append(sum)
        
        rowMax=[]
        for i in range(len(sums)):
            rowMax.append(max(sums[i]))
        maximum=max(rowMax)
 
        return maximum
        '''
        cur_sum=max_sum=nums[0]
        
        for num in nums[1:]:
            cur_sum=max(num,cur_sum+num)
            max_sum=max(max_sum, cur_sum)
        return max_sum
        
        
        #keypoint
        '''
        key1
        연속적인 배열의 합이므로 a+b+c...+g<g이면 g부터 다시시작하는게 더 큰값을 가지게 할 수 있다.
        오름차순이 아니므로 => cur로 계산
        key2
        a+b+c...+g<g여도 a+b+c>g일수 있다 왜냐하면 오름차순이 아니므로!!
        => max 필요
        '''