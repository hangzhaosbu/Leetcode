class UnionFind
{
    int[] parent;
    int count = 0;
    
    public UnionFind(int n)
    {
        parent = new int[n];
        count = n;
        
        for(int i = 0; i < n; ++i)
        {
            parent[i] = i;
        }
    }
    
    public int find(int x)
    {
        if(x != parent[x])
        {
            parent[x] = find(parent[x]);
        }
        
        return parent[x];
    }
    
    public boolean unionfind(int x, int y)
    {
        int px = find(x), py = find(y);
        
        if(px != py)
        {
            if(px < py)
            {
                parent[px] = py;
            }
            else
            {
                parent[py] = px;
            }
            
            count--;
            return true;
        }
        
        return false;
    }
}

class Solution
{
    public boolean validTree(int n, int[][] edges)
    {
        if(edges.length != n - 1) return false;
        
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges)
        {
            int x = edge[0], y = edge[1];
            
            if(uf.unionfind(x, y) == false)
            {
                return false;
            }
        }
        return uf.count == 1;
    }
}