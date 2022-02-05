class Solution(object):
    def getSum(self, a, b):
        """
        :type a: int
        :type b: int
        :rtype: int
        """
        #함수 이용하는법
        '''
        list1=[a,b]
        return sum(list1)
        '''

        #maybe 의도한것 bitwise
        mask=0xffffffff
        sum1=(a^b) & mask
        carry=a&b
        
        while(carry!=0):
            a=sum1
            b=(carry<<1) & mask
            sum1=(a^b) & mask
            carry=a&b 
        #sumd이 -면
        print(sum1)
        if sum1 & 0x80000000 :
            sum1 -= 0x100000000
        return sum1