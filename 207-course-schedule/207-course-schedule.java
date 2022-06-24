class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        
        for(int i = 0; i < numCourses; ++i)
        {
            adj[i] = new ArrayList<Integer>();
        }
        for(int[] prerequisite : prerequisites)
        {
            adj[prerequisite[1]].add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        
        for(int i = 0; i < numCourses; ++i)
        {
            if(indegree[i] == 0)
            {
                queue.offer(i);
                count++;
            }
        }
        
        while(!queue.isEmpty())
        {
            int node = queue.poll();
            
            for(Integer neighbor : adj[node])
            {
                indegree[neighbor]--;
                
                if(indegree[neighbor] == 0)
                {
                    queue.offer(neighbor);
                    count++;
                }
            }
        }
        
        return count == numCourses;
    }
}