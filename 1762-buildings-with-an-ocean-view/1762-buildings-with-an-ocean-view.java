class Solution {
    public int[] findBuildings(int[] heights) {
        int N = heights.length;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = N - 1; i > -1; i--)
        {
            if(!stack.isEmpty())
            {
                if(heights[stack.peek()] < heights[i])
                {
                    stack.push(i);
                }
            }
            else
            {
                stack.push(i);
            }
        }
        
        int[] result = new int[stack.size()];
        int p = 0;
        
        while(!stack.isEmpty())
        {
            result[p++] = stack.pop();
        }
        
        return result;
    }
}