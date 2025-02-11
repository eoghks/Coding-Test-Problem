class Solution {
    //solution 1 StringBuilder + subString
    /*
    public String removeOccurrences(String s, String part) {
        StringBuilder res = new StringBuilder();
        int n = part.length();
        for (char c : s.toCharArray()) {
            res.append(c);
            if (res.length() >= n && res.substring(res.length() - n).equals(part)) {
                res.delete(res.length() - n, res.length());
            }
        }
        return res.toString();
    }
    */
     public String removeOccurrences(String s, String part) {
        char[] stack = new char[s.length()];
        int stackSize = 0;
        char[] target = part.toCharArray();
        int targetLength = target.length;
        char targetEndChar = target[targetLength - 1];

        for (char c : s.toCharArray()) {
            stack[stackSize++] = c;

            if (c == targetEndChar && stackSize >= targetLength) {
                int i = stackSize - 1;
                int j = targetLength - 1;
                
                while (j >= 0 && stack[i] == target[j]) {
                    i--;
                    j--;
                }

                if (j < 0) {
                    stackSize = i + 1;
                }
            }
        }
        return new String(stack, 0, stackSize);
    }
}