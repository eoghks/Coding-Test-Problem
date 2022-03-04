class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        
        maxLen=0
        cur=0
        char=[]
        for i in s:
            if i in char:
                index=char.index(i)
                del(char[:index+1])
                char.append(i)
            else:
                char.append(i)
                print(char)
                maxLen=max(maxLen,len(char))
        
        return maxLen