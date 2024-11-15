class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = n-1;
        
        while(l+1< n  && arr[l+1] >= arr[l])
            l++;
        while(r-1>=0 && arr[r-1] <= arr[r])
            r--;
        
        //내림차순이 존재하지 않는 경우
        if(r<=l)
            return 0;
        
        int st = r;
        while(st<n && arr[st] < arr[0])
            st++;
        
        //내림 차순 부분을 제거하려는데 
        //마지막으로 첫번째 원소보다 뒷 부분이 모두 작은 경우
        if(st>=n)
            return n- Math.max(l+1, n-r);
        
        int res = Math.max(0, 1+n-st);
        for(int i=1; i<=l; i++) {
            while(st<n&& arr[st] < arr[i])
                st++;
            if(st >= n)
                break;
            res = Math.max(res, 1 + i + n - st);
        }
        return n - Math.max(res, Math.max(l + 1, n - r));
    }
    
}