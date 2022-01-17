class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """
        '''
        if(len(nums1)>m):
            for i in range(len(nums1)-m):
                nums1.pop()
                ->어차피 m이상의 인덱스를 지우면 되기때문에 del을 이용하여 인덱스로 지우기
        '''
        
        del nums1[m:]
        """
        i=0;
        j=0;
        while(i<m and j< n):
            if(nums1[i]>nums2[j]):
                nums1.insert(i,nums2[j])
                j+=1
                m+=1
            i+=1
        if(j<n):
            nums1+=nums2[j:]
            '''for k in range(j,n):
                nums1.append(nums2[k])
                -> python이기 때문에 합쳐서 sort하면된다.'''
        """
        
        nums1+=nums2
        nums1.sort()
        
        
        #내가 쓰는 언어는 python이다. 최대한 언어을 활용할것 !! 그래야 간단한 코딩이 가능 -> 성능적으로 유리