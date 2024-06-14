class Solution {
    public String reorganizeString(String s) {
        //1223333
        //0 -> 짝수 채우기
        //1부터 홀수 채우기
        if(s.length() == 1) {
            return s;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] strs = s.split("");
        for(String str: strs) {
            if(map.containsKey(str)) 
                map.put(str, map.get(str) + 1);
            else
                map.put(str, 1);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        
        //2 -> 2 3 -> 3 4-> 3 5-> 4 (n+1)/2 +1
        if(entryList.get(0).getValue() >= (s.length()+1)/2 + 1) {
            return "";
        }
        int i = 0;
        for(Map.Entry<String, Integer> entry : entryList) {
            for(int j=0; j < entry.getValue(); j++) {
                strs[i] = entry.getKey();
                if(i+2 >= s.length()){
                   i = 1 ; 
                } else{
                    i += 2;
                }
            }
        }
        return String.join("", strs);
    }
}