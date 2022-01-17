class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        #i를 2개씩 넘기 위해 사용할 변수
        check=0
        sum =0
        #마지막 한문제 제외해서 2칸씩 확인 할 수 있도록
        for i in range(len(s)):
            if(check==1):
                check=0
                continue
            #I
            if(s[i]=="I"):
                if(i<len(s)-1 and s[i+1]=="V"):
                    sum+=4
                    check=1
                elif(i<len(s)-1 and s[i+1]=="X"):
                    sum+=9
                    check=1
                else:
                    sum+=1
            #X
            elif(s[i]=="X"):
                if(i<len(s)-1 and s[i+1]=="L"):
                    sum+=40
                    check=1
                elif(i<len(s)-1 and s[i+1]=="C"):
                    sum+=90
                    check=1
                else:
                    sum+=10
            #C
            elif(s[i]=="C"):
                if(i<len(s)-1 and s[i+1]=="D"):
                    sum+=400
                    check=1
                elif(i<len(s)-1 and s[i+1]=="M"):
                    sum+=900
                    check=1
                else:
                    sum+=100
            #V
            elif(s[i]=="V"):
                sum+=5
            #L
            elif(s[i]=="L"):
                sum+=50
            #D
            elif(s[i]=="D"):
                sum+=500
            #M
            elif(s[i]=="M"):
                sum+=1000
        return sum
            