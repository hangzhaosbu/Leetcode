class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); ++i)
        {
            Character c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
            {
                stack.add(c);
            }
            else
            { 
                if(!stack.isEmpty() && ((c == ')' && stack.peek() == '(') || (c == ']' && stack.peek() == '[') || (c == '}' && stack.peek() == '{')))
                {
                    stack.pop();
                }
                else
                {
                    stack.add(c);
                }
            }
            
        }
        
        return stack.isEmpty();
    }
}