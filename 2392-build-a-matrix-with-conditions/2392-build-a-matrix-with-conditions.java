class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] result = new int[k][k];
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        
        List<Integer> rows = canFinish(k, rowConditions);
        if(rows.size() != k) return new int[][]{};
        
        List<Integer> cols = canFinish(k, colConditions);
        if(cols.size() != k) return new int[][]{};
        
        for(int i = 0; i < k; ++i)
        {
            hashmap.put(cols.get(i), i);
        }
        
        for(int i = 0; i < k; ++i)
        {
            result[i][hashmap.get(rows.get(i))] = rows.get(i);
        }
        
        return result;
    }
    
    
    public List<Integer> canFinish(int numCourses, int[][] prerequisites)
    {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        List<Integer> rows = new ArrayList<>();
        
        for(int i = 0; i < numCourses; ++i)
        {
            adj[i] = new ArrayList<Integer>();
        }
        
        for(int[] prerequisite : prerequisites)
        {
            adj[prerequisite[0] - 1].add(prerequisite[1] - 1);
            indegree[prerequisite[1] - 1]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < numCourses; ++i)
        {
            if(indegree[i] == 0)
            {
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty())
        {
            int node = queue.poll();
            rows.add(node + 1);
            
            for(Integer neighbor : adj[node])
            {
                indegree[neighbor]--;
                
                if(indegree[neighbor] == 0)
                {
                    queue.offer(neighbor);
                }
            }
        }
        
        return rows;
    }
}