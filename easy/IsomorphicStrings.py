class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        string1=[]
        string2=[]
        for i in range(len(s)):
            if s[i] in string1 :
                j=string1.index(s[i])
                if(t[i]!=string2[j]):
                    return False\
                
            if t[i] in string2 :
                j=string2.index(t[i])
                if(s[i]!=string1[j]):
                    return False    
            else:
                string1.append(s[i])
                string2.append(t[i])
        
        
        return True