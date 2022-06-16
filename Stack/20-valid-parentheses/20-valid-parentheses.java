class Solution {
    public boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();
        int N = s.length();
        
        for(int i = 0; i < N; ++i)
        {
            if(!stack.isEmpty() && ((stack.peek() == '(' && s.charAt(i) == ')') || (stack.peek() == '[' && s.charAt(i) == ']') || (stack.peek() == '{' && s.charAt(i) == '}')))
            {
                stack.pop();
            }
            else
            {
                stack.push(s.charAt(i));
            }
        }
        
        return stack.isEmpty();
    }
}