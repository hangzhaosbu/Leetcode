class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length;
        int[] result = new int[N];
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        
        for(int i = 0; i < N; i++)
        {
            int temperature = temperatures[i];
            while(!stack.isEmpty() && temperature > stack.peek().getKey())
            {
                Pair<Integer, Integer> curt = stack.pop();
                result[curt.getValue()] = i - curt.getValue();
            }
            
            stack.push(new Pair<>(temperature, i));
        }
        
        return result;
    }
}