class Solution {
    public int[] numsSameConsecDiff(int n, int k)
    {
        //BFS
        Queue<String> queue = new LinkedList<>();
        HashSet<Integer> result = new HashSet<>();
        for(char i = '1'; i <= '9'; i++)
        {
            queue.offer(String.valueOf(i));
        }
        
        
        while(!queue.isEmpty())
        {
            String s = queue.poll();
            
            if(s.length() == n)
            {
                result.add(Integer.parseInt(s));
            }
                
            
            char last_letter = s.charAt(s.length() - 1);
            
            if(s.length() < n && last_letter + k <= 57)
            {
                queue.offer(s + ((char) (last_letter + k)));
            }
            
            if(s.length() < n && last_letter - k >= 48)
            {
                queue.offer(s + ((char) (last_letter - k)));
            }
        }
        
        int[] ans = new int[result.size()];
        int p = 0;
        
        for(int val : result)
        {
            ans[p++] = val;
        }
        
        return ans;
    }
}