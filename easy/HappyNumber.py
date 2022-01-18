class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        data=[]
        while(n!=1):
            sum=0
            #string으로 바꾸어 index로 각 숫자에 접근
            strn=str(n)
            for i in strn :
                sum+=int(i)**2
            if sum in data:
                return False
            data.append(sum)
            n=sum
        
        return True