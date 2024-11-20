class Solution {
    public int takeCharacters(String s, int k) {
        char[] ch = s.toCharArray();
        int n = s.length();
        int[] arr = new int[3];
        for(char c: ch)
            arr[c-'a']++;
        
        if(arr[0] < k || arr[1] < k || arr[2] < k)
            return -1;
        
        int left = 0;
        int right = 0;
        int max = 0;
        while(left < n) {
            while(right < n && arr[ch[right] - 'a'] > k) {
                arr[ch[right] - 'a']--;
                right++;
            }
            
            if(arr[0] < k || arr[1] < k || arr[2] < k)
                break;
            
            if(max < right - left)
                max = right -left;
            
            arr[ch[left] - 'a']++;
            left++;
        }
        
        return n-max;
    }
}