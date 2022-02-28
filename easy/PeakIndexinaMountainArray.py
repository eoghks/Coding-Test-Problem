class Solution(object):
    def peakIndexInMountainArray(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        for i in range(1,len(arr)-1):
            if arr[i]>arr[i+1]:
                return i