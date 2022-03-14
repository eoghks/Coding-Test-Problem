from collections import Counter
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        #이해하기 조금 어려우나 효율은 가장 좋은 방법
        
        if len(s) <= 1:
            return s
        i,l=0,0
        
        for j in range(len(s)):
            #처음에 들어오면 s[0:1] ->s[0] 따라서 무조건 성립 l=1로 바뀐다.
            print(s[j-l: j+1])
            #j-l을 해주는 이유가 j는 끝 index를 항상의미하며, l길이보다 짧거나 같은길이의 회문은 중요하지 않다. ->최대길이를 구하는것이기때문
            #l보다 1더긴 길이의 회문을 확인
            if s[j-l: j+1] == s[j-l: j+1][::-1]:
                i, l = j-l, l+1
                print(i,j,l)
            #뒤에 조건은 회문이면을 의미
            #j-l>0의 의미: 현재 확인중이 index가 길이보다 더 앞에와잇다 -> 더긴길이도 확인해봐라
            #j+1이 문자열의 끝을 의미하고 j가 1증가하니 오른쪽으로 한칸 증가되었다 따라서 왼쪽으로 한칸증가하여 대칭구조를 맞춘다.
            #회문의 중간부분도 회문이다. (이게 중요)
            #l보다 2더 긴 길이의 회문을 확인
            elif j-l > 0 and s[j-l-1: j+1] == s[j-l-1: j+1][::-1]:
                i, l = j-l-1, l+2
                print(i,j,l)
        
        return s[i:i+l]
        
    '''
        #내가 이해하기 쉬운코드로 저장
        res = ''
        
        # i index가 중심!!
        for i in range(len(s)):
            #홀수개의 char문자로 이루어진경우
            odd = self.helper(s, i, i)
            #짝수개의 char문자로 이루어진경우
            even = self.helper(s, i, i+1)
            res = max(res, odd, even, key = len)
        
        # return 
        return res
        
    #index를 중심으로 대칭구조로 확인하기 함수
    def helper(self, s, l, r):
        # l과r 확인 -> 범위를 넘어가지않게(대칭구조를 넘어가면 의미 x)
        while l >= 0 and r < len(s) and s[l] == s[r]:
            l -= 1
            r += 1
        
        return s[l+1:r]
    ;;;'''
    '''
        가장 간단한 방법이나 time limit 절대안됨
        long=""
        if len(s) <=1:
            return s
        for i in range(len(s)):
            for j in range(len(s), i, -1):
                if(len(long)>=j-i):
                    continue
                elif s[i:j]==s[i:j][::-1]:
                    long=s[i:j]
        
        return long
        '''