import collections
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        '''
        if(len(s)!=len(t)):
            return False
        
        dict1={}
        dict2={}
        for i,j in zip(s,t):
            if i in dict1.keys():
                dict1[i]=dict1[i]+1
            else:
                dict1[i]=1
            
            if j in dict2.keys():
                dict2[j]=dict2[j]+1
            else:
                dict2[j]=1
        
        
        for i in dict1.keys():
            if i not in dict2.keys():
                return False
            if(dict1[i]!=dict2[i]):
                return False
        
        return True
        '''
        #####################
        """
        s=sorted(s)
        t=sorted(t)
        if s==t :
            return True
        else:
            return False
        """
        #####################
        if collections.Counter(s) == collections.Counter(t):
            return True
        else:
            return False