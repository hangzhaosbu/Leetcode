class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int N = s.length();
        int count = 0;
        
        for(int i = 0; i < N; ++i)
        {
            if(!stack.empty() && s.charAt(stack.peek()) == '(' && s.charAt(i) == ')')
            {
                stack.pop();
                int left = stack.empty() ? -1 : stack.peek();
                count = Math.max(count, i - left);
            }
            else
            {
                stack.add(i);
            }
        }
        
        return count;
    }
}