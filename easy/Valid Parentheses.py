class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        type=[]
        openP=["(", "[", "{"]
        closeP=[")", "]", "}"]
        error=True
        for i in range(len(s)):
            #stack에 쌓고
            if(s[i]=="(" or s[i]=="[" or s[i]=="{"):
                type.append(s[i])
            #stack에서 제거 
            elif(len(type) > 0 and openP.index(type[-1])==closeP.index(s[i])):
                type.pop()
            else:
                error=False
                break
        #stack이 empty면 true
        if(error and len(type)==0):
            return True
        else:
            return False