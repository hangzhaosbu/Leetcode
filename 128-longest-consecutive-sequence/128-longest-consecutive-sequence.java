class UnionFind
{
    HashMap<Integer, Integer> parents = new HashMap<>();
    
    public UnionFind(int[] nums)
    {
        for(int num : nums)
        {
            parents.put(num, num);
        }
    }
    
    public int find(int x)
    {
        if(parents.get(x) != x)
        {
            parents.put(x, find(parents.get(x)));
        }
        
        return parents.get(x);
    }
    
    public void union(int x, int y)
    {
        int px = find(x), py = find(y);
        
        if(px != py)
        {
            if(px < py)
            {
                parents.put(x, py);
            }
            else
            {
                parents.put(y, px);
            }
        }
    }
        
}

class Solution
{
    public int longestConsecutive(int[] nums) {
        UnionFind uf = new UnionFind(nums);
        HashMap<Integer, Integer> count = new HashMap<>();
        int result = 0;
        
        for(int num : nums)
        {
            if(uf.parents.containsKey(num - 1))
            {
                uf.union(num - 1, num);
            }
            
            if(uf.parents.containsKey(num + 1))
            {
                uf.union(num + 1, num);
            }
        }
        
        for(int key : uf.parents.keySet())
        {
            uf.parents.put(key, uf.find(key));
        }
        
        for(int key : uf.parents.keySet())
        {
            count.put(uf.parents.get(key), count.getOrDefault(uf.parents.get(key), 0) + 1);
        }
        
        for(int key : count.keySet())
        {
            result = Math.max(count.get(key), result);
        }
        return result;
    }
}