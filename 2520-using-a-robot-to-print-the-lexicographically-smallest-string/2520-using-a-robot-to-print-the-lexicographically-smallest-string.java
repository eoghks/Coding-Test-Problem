class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        char[] minSuffix = new char[n];
        minSuffix[n - 1] = s.charAt(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            minSuffix[i] = (char)Math.min(s.charAt(i), minSuffix[i + 1]);
        }

        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        int i=0;

         while (i < n) {
            stack.push(s.charAt(i++));

            while (!stack.isEmpty() && stack.peek() <= minSuffix[i == n ? n - 1 : i]) {
                result.append(stack.pop());
            } 
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
}