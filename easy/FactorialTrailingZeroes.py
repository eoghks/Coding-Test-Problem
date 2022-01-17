class Solution(object):
    #5가 하나들어갈때마다 0이하나 붙는다-> 25의 배수는 5가 2개이므로 5로 한번 zero수를 더하고 25로한번 zero의수를 더하면된다.
    def trailingZeroes(self, n):
        """
        :type n: int
        :rtype: int
        """
        p=5
        countzero=0
        while(n>=p):
            #나누면 p로 나누어지는 n의 수가 나온다.-> 5의갯수를 구할수 있다.
            countzero+=n//p;
            p*=5
            
        return countzero