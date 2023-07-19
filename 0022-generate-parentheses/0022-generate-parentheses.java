class Solution {
    public List<String> generateParenthesis(int n)
    {
        List<String> result = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        backtracking(0, 0, n, stack, result);
        return result;
    }
    
    private void backtracking(int left, int right, int n, Stack<Character> stack, List<String> result)
    {
        if(left == n && right == n)
        {
            String str = stack.stream().map(s -> s.toString()).collect(Collectors.joining(""));
            result.add(str);
            return;
        }
        
        if(left > right)
        {
            stack.push(')');
            backtracking(left, right + 1, n, stack, result);
            stack.pop();
        }
        
        if(left < n)
        {
            stack.push('(');
            backtracking(left + 1, right, n, stack, result);
            stack.pop();
        }
    }
}