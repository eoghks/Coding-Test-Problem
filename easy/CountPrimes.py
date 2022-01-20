class Solution(object):
    def countPrimes(self, n):
        if n<3: return 0
        PrimeTable=[True]*(n)
        p=2
        #p*p로 확인하는 이유 -> p*p이하는{n<p인 모든수}(p-n)에 의해 확인이 다되었기때문에 확인할 필요가없다.
        while p*p<=n-1:
            if PrimeTable[p]==True:
                #p의 제곱부터 하는이유도 위에이유와 비슷하다.
                for i in range(p**2,n,p): PrimeTable[i]=False
            p += 1
        return sum(PrimeTable)-2