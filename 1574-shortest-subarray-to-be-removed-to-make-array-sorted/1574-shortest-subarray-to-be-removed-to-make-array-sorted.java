class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length;
        int l = 0, r = len - 1;
        while(l + 1 < len && arr[l + 1] >= arr[l]) l++;
        while(r - 1 >= 0 && arr[r - 1] <= arr[r]) r--;
        if(r <= l) return 0;
        int st = r;
        while(st < len && arr[st] < arr[0]) st++;
        int ans = 0;
        if(st >= len) return len - Math.max(l + 1, len - r);
        ans = Math.max(ans, 1 + len - st);
        for(int i = 1; i <= l; i++) {
            while(st < len && arr[st] < arr[i]) st++;
            if(st >= len) break;
            ans = Math.max(ans, 1 + i + len - st);
        }
        return len - Math.max(ans, Math.max(l + 1, len - r));
        /*
        int n = arr.length;
        int l = 0;
        int r = n-1;
        
        while(l+1< n  && arr[l+1] >= arr[l])
            l++;
        while(r-1>=0 && arr[r-1] <= arr[r])
            r--;
        
        if(r<=l)
            return 0;
        
        int st = r;
        while(st<n && arr[st] < arr[0])
            st++;
        if(st>=n)
            return n- Math.max(l+1, n-r);
        
        int res = 1+n-st;
        for(int i=1; i<=l; i++) {
            while(st<n&& arr[st] < arr[i])
                st++;
            if(st >= n)
                break;
            res = Math.max(res, l+i+n-st);
        }
        System.out.println(l);
        System.out.println(r);
        return n-Math.max(res, Math.max(l+1, n-r));*/
    }
    
}