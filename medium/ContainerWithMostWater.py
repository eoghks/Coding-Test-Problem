class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        #가로가 가장 넓은 상태에서 줄어들게 설정
        #right와 left로 나눈이유 -> 어차피 최대한 긴hegiht가 필요하기때문에 
        maximum=0
        left=0
        right=len(height)-1
        
        max_height=max(height)
        
        #max_height*(right>left) > maximum이라면 더이상 해도 가로는 점점줄기때문에 더이상 해봣자 커질수가없다. ->bound값이라 생각
        #따라서 바운드 값에의해 반복문 조기 종료
        while(right-left>0) and max_height*(right-left) > maximum:
            #짧은쪽 height를 이용해야 물이 넘치지않는다.
            maximum=max(maximum,(right-left)*min(height[right],height[left]))
            #짧은쪽 height가 변경되어야 가로가 줄어들어도 총 면적이 커질확률이 높다.
            if(height[right]>height[left]):
                left+=1
            else:
                right-=1
            
        return maximum
    #O(n)의 time complexity를 가진다.