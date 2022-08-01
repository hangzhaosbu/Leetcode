class Solution {
    public int[] findPermutation(String s)
    {
        int len = s.length(), p = 0;
        int[] result = new int[len + 1];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 1; i <= len; ++i)
        {
            if(s.charAt(i - 1) == 'I')
            {
                stack.push(i);
                
                while(!stack.isEmpty())
                {
                    result[p++] = stack.pop();
                }
            }
            
            else
            {
                stack.push(i);
            }
        }
        
        stack.push(len + 1);
        
        while(!stack.isEmpty())
        {
            result[p++] = stack.pop();
        }
        
        return result;
    }
}