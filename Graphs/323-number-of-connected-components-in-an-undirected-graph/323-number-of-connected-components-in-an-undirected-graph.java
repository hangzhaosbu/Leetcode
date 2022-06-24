class UnionFind
{
    int[] parent;
    public UnionFind(int n)
    {
        parent = new int[n];
        for(int i = 0; i < n; ++i)
        {
            parent[i] = i;
        }
    }
    
    public int find(int x)
    {
        if(this.parent[x] != x)
        {
            this.parent[x] = find(this.parent[x]);
        }
        
        return this.parent[x];
    }
    
    public void union(int x, int y)
    {
        int px = find(x), py = find(y);
        
        if(px != py)
        {
            if(px < py)
            {
                this.parent[px] = py;
            }
            else
            {
                this.parent[py] = px;
            }
        }
    }
}

class Solution {
    public int countComponents(int n, int[][] edges)
    {
        UnionFind uf = new UnionFind(n);
        
        for(int[] edge : edges)
        {
            uf.union(edge[0], edge[1]);
        }
        
        for(int i = 0; i < n; ++i)
        {
            uf.find(i);
        }
        
        HashSet<Integer> hashset = new HashSet<>();
        
        for(int i = 0; i < n; ++i)
        {
            hashset.add(uf.parent[i]);
        }
        
        return hashset.size();
    }
}