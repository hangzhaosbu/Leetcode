class Solution {
    public String alienOrder(String[] words)
    {
        HashMap<Character, HashSet<Character>> adj = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        
        int N = words.length;
        
        for(String word : words)
        {
            for(int i = 0; i < word.length(); ++i)
            {
                adj.put(word.charAt(i), new HashSet<>());
                indegree.put(word.charAt(i), 0);
            }
        }
        
        
        for(int i = 0; i < N - 1; ++i)
        {
            String s = words[i];
            String t = words[i + 1];
            
            if(s.length() > t.length() && s.substring(0, t.length()).equals(t))
            {
                return "";
            }
            
            for(int j = 0; j < Math.min(s.length(), t.length()); ++j)
            {
                if(s.charAt(j) == t.charAt(j))
                {
                    continue;
                }
                
                if(!adj.get(s.charAt(j)).contains(t.charAt(j)))
                {
                    adj.get(s.charAt(j)).add(t.charAt(j));
                    indegree.put(t.charAt(j), indegree.getOrDefault(t.charAt(j), 0) + 1);
                }
                
                break;
            }
        }
        
        Queue<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        
        for(Character key : indegree.keySet())
        {
            if(indegree.get(key) == 0)
            {
                queue.offer(key);
            }
        }
        
        
        while(!queue.isEmpty())
        {
            Character node = queue.poll();
            result.append(node);
            
            for(Character neighbor : adj.get(node))
            {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                
                if(indegree.get(neighbor) == 0)
                {
                    queue.offer(neighbor);
                }
            }
        }
        
        return result.length() == indegree.size() ? result.toString() : "";
    }
}