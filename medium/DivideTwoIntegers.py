class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        '''
        positive = (dividend < 0) is (divisor < 0)
        
        if(positive):
            res=int(dividend/divisor)
        else:
            res=-(int(dividend/-divisor))
        
        return min(max(-2147483648, res), 2147483647)
        '''
        
        #아래 코드가 더빠른 runtime을 가진다.
        #positive는 결국 양수 is 양수, 음수 is 음수 -> true
        positive = (dividend < 0) is (divisor < 0)
        #절대값으로 계산해야 용이
        dividend, divisor = abs(dividend), abs(divisor)
        res = 0
        
        # nlogn을 가질것같다. (첫번째가 n, 두번째가 logn번 실행)
        while dividend >= divisor:
            temp, i = divisor, 1
            #최대한으로 2**n까지 한번 dividend에서 빼준다.
            while dividend >= temp:
                dividend -= temp
                res += i
                #temp<<1만큼 이동하면 temp*2 이므로 res도 i*2만큼씩 증가하여야 성립된다.
                i <<= 1
                temp <<= 1
            #dividend=dividend-res*temp 
            #그후 dividend >= divisor면 다시 실행
            
        if not positive:
            res = -res
        return min(max(-2147483648, res), 2147483647)
    
        #이렇게하는 이유 컴퓨터는 2진수로 이루어져있고, 2진수기때문에 '<<' 연산이 빠르다. 
     
        