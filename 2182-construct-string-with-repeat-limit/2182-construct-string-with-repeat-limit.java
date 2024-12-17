class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> (b-a));
        StringBuffer sb = new StringBuffer();
        ArrayList<Character> list = new ArrayList<Character>();
        Stack<Character> stk = new Stack<Character>();
        int cnt = 0;
        //add pq
        for(char c: s.toCharArray()) {
            pq.add(c);
        }
        
        char prev = pq.peek();
        while(!pq.isEmpty()){
            char cur = pq.poll();
            
            //이전 문자와 같으면
        	if(cur==prev){
                //limit보다 작으면 추가
        		if(cnt<repeatLimit){
        			sb.append(cur);
        		}
                //아니면 stack에 추가
        		else{
        			stk.add(cur);
        		}
        		cnt++;
        	}
            //이전 문자와 다르면
        	else{
                //stack이 빈경우
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