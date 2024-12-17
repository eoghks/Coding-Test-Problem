class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> (b-a));
        StringBuffer sb = new StringBuffer();
        ArrayList<Character> list = new ArrayList<Character>();
        Stack<Character> stk = new Stack<Character>();
        int cnt = 0;
        
        for(char c: s.toCharArray()) {
            pq.add(c);
        }
        
        char prev = pq.peek();
        while(!pq.isEmpty()){
            char cur = pq.poll();
            
        	if(cur==prev){
        		if(cnt<repeatLimit){
        			sb.append(cur);
        		}
        		else{
        			stk.add(cur);
        		}
        		cnt++;
        	}
        	else{
        		if(stk.isEmpty()){
        			cnt=0;
        			sb.append(cur);
        			prev = cur;
        			cnt++;
        		}
        		else{
        			sb.append(cur);
        			cnt=0;
        			while(!stk.isEmpty() && cnt<repeatLimit){
        				sb.append(stk.pop());
        				cnt++;
        			}
        		}
        	}
        }
        return sb.toString();
    }
}