class Solution {
    char[] ch = {'0', '1'};
    String res = null;
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        List<String> list = new ArrayList<>(Arrays.asList(nums));
        solution(n, list, new StringBuilder());
        return res;
    }

    private boolean solution(int n, List<String> list, StringBuilder sb) {
        if(sb.length() == n) {
            if(!list.contains(sb.toString())) {
                res = sb.toString();
                return true;
            }
            return false;
        }
        for(char c: ch) {
            sb.append(c);
            if(solution(n, list, sb)) {
                return true;
            }
            sb.deleteCharAt(sb.length()-1);
        }
        return false;
    }
}