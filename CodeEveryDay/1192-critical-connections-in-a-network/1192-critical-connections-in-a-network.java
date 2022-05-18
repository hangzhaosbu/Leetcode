class Solution {
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) 
    {
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++)
        {
            graph[i] = new ArrayList<>();
        }
        
        for(List<Integer> connection : connections)
        {
            graph[connection.get(0)].add(connection.get(1));
            graph[connection.get(1)].add(connection.get(0));
        }
        
        HashSet<List<Integer>> connectionsSet = new HashSet<>(connections);
        int[] rank = new int[n];
        Arrays.fill(rank, -2);
        
        dfs(0, 0, graph, rank, connectionsSet);
        return new ArrayList<>(connectionsSet);
    }
    
    private int dfs(int node, int depth, List<Integer>[] graph, int[] rank, HashSet<List<Integer>> connectionsSet)
    {
        if(rank[node] >= 0)
        {
            return rank[node];
        }
        
        rank[node] = depth;
        int minimumRank = depth;
        
        for(int i = 0; i < graph[node].size(); i ++)
        {
            int neighbor = graph[node].get(i);
            if(rank[neighbor] == depth - 1)
            {
                continue;
            }
            
            int neighborMinimumRank = dfs(neighbor, depth + 1, graph, rank, connectionsSet);
            minimumRank = Math.min(minimumRank, neighborMinimumRank);
            
            if(neighborMinimumRank <= depth)
            {
                connectionsSet.remove(Arrays.asList(node, neighbor));
                connectionsSet.remove(Arrays.asList(neighbor, node));
            }
        }
        
        return minimumRank;
    }
}