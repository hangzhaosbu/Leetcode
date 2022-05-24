class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int N = s.length();
        int count = 0;
        
        for(int i = 0; i < N; ++i)
        {
            if(!stack.empty() && s.charAt(stack.peek()) == '(' && s.charAt(i) == ')')
            {
                int right = i;
                int left = stack.peek();
                stack.pop();
                
                if(!stack.empty())
                {
                    left = Math.min(left, stack.peek());
                }
                else
                {
                    left = Math.min(-1, left);
                }
                
                count = Math.max(count, right - left);
            }
            else
            {
                stack.add(i);
            }
        }
        
        return count;
    }
}