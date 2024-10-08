class Solution {
    public String convert(String s, int numRows) {
        Map<Integer, StringBuilder> map = new HashMap<>();
        for(int i=0; i<numRows; i++) {
            map.put(i, new StringBuilder());
        }
        int idx = 0;
        boolean isPlus = true;
        for(int i=0; i<s.length(); i++) {
            StringBuilder sb = map.get(idx%numRows);
            sb.append(s.charAt(i));
            if(isPlus) {
                idx++;
            } else{
                idx--;
            }
            if(idx==0 || idx== numRows-1)
                isPlus = !isPlus;
        }
        
        StringBuilder res = new StringBuilder();
        for(int i=0; i<numRows; i++) {
            res.append(map.get(i).toString()); 
        }
        return res.toString();
    }
}