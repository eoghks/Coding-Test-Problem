class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        count=0
        for i in range(len(flowerbed)):
            #꽃이 이미 심어진 경우는 생략한다.
            if(flowerbed[i]==1):
                continue
            
            #꽃이 안심어진경우
            
            #배열길이 1인데 꽃이 안심어진 경우
            if(len(flowerbed)==1):
                count+=1
                continue
                
            #꽃이 안심어진경우(배열길이 2이상)
            if(i==0):
                if(flowerbed[i+1]==0):
                    flowerbed[i]=1
                    count+=1
                continue
            
            if(i==len(flowerbed)-1):
                if(flowerbed[i-1]==0):
                    flowerbed[i]=1
                    count+=1
                continue
            
            if(flowerbed[i+1]==0 and flowerbed[i-1]==0):
                    flowerbed[i]=1
                    count+=1
        if(count>=n):
            return True
        return False
            
                