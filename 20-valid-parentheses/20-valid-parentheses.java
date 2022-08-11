class Solution {
    public boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); ++i)
        {
            Character c = s.charAt(i);
            
            if(c == ')' || c == '}' || c == ']')
            {
                if(stack.isEmpty())
                {
                    return false;
                }
                
                if(c == ')' && stack.peek() == '(')
                {
                    stack.pop();
                }
                
                else if(c == ']' && stack.peek() == '[')
                {
                    stack.pop();
                }
                
                else if(c == '}' && stack.peek() == '{')
                {
                    stack.pop();
                }
                else
                {
                    stack.add(c);
                }
            }
            
            else
            {
                stack.add(c);
            }
        }
        
        return stack.isEmpty();
    }
}