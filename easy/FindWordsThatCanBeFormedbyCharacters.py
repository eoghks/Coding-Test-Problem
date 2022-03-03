from collections import Counter
class Solution(object):
    def countCharacters(self, words, chars):
        """
        :type words: List[str]
        :type chars: str
        :rtype: int
        """
        count = Counter(chars)
        ans=0
        
        for word in words:
            tempCount = count.copy()
            for c in word:
                tempCount[c] -= 1
                
                if tempCount[c] < 0:
                    ans -= len(word)
                    break
            ans += len(word)
        return ans