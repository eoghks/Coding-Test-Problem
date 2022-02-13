class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        slist=s.split(" ")
        result=""
        #slice를 이용한 풀이
        for i in slist:
            result+=i[::-1]
            result+=" "
        result=result[:-1]
        return result
        #reversed를 이용한 풀이
        """for i in slist:
            result+="".join(reversed(i))
            result+=" "
        result=result[:-1]
        return result"""
        #slice를 이용한 풀이가 runtime이 더빨랐다.