class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        k=k%len(nums)
        #while(k>len(nums)):
            #k=k-len(nums)
        #j=nums[:-k]
        #del(nums[:-k])
        #for i in j:
            #nums.append(i)
        nums[:]=nums[-k:]+nums[:-k]
        
        #[:]-> 깊은 복사를 만드는 key point