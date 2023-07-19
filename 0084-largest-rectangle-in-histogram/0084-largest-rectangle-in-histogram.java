class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>(); // pair : index, height
        int result = 0;
        
        for(int i = 0; i < heights.length; i++)
        {
            int h = heights[i];
            int start = i;
            while(!stack.isEmpty() && stack.peek().getValue() > h)
            {
                Pair<Integer, Integer> curt = stack.pop();
                int index = curt.getKey(), height = curt.getValue();
                result = Math.max(result, height * (i - index));
                start = index;
            }
            stack.push(new Pair<>(start, h));
        }
        
        int N = heights.length;
        
        while(!stack.isEmpty())
        {
            Pair<Integer, Integer> curt = stack.pop();
            int index = curt.getKey(), height = curt.getValue();
            result = Math.max(result, height * (N - index));
        }
        
        return result;
    }
}