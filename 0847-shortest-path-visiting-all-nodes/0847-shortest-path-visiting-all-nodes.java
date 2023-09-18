class Solution {
    public int shortestPathLength(int[][] graph)
    {
        if(graph.length==1)
        {
            return 0;
        }
        
        int n=graph.length;
        
        Queue<Node> queue=new LinkedList<>();
        
        Set<Integer>[] visited=new HashSet[n];
        
        for(int i=0;i<n;i++)
        {
            int mask=(1<<i);
            queue.add(new Node(i,0,mask));
            visited[i]=new HashSet<>();
            visited[i].add(mask);
        }
        
        while(!queue.isEmpty())
        {
            Node node=queue.poll();
            
            if(node.mask==(1<<n)-1)
            {
                return node.steps;
            }
            
            for(int neighbour:graph[node.nodeval])
            {
                int newmask=node.mask | (1<<neighbour);
                
                if(visited[neighbour].contains(newmask)==false)
                {
                    visited[neighbour].add(newmask);
                    queue.add(new Node(neighbour,node.steps+1,newmask));
                }
            }
        }
        
        return 0;
    }
}

class Node{
    int nodeval;
    int steps;
    int mask;
    
    public Node(int nodeval, int steps, int mask)
    {
        this.nodeval=nodeval;
        this.steps=steps;
        this.mask=mask;
    }
}