class UnionFind:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.rank = [1] * n
    
    def find(self, x):
        while x != self.parent[x]:
            self.parent[x] = self.parent[self.parent[x]]
            x = self.parent[x]
        return x
    
    def union(self, x, y):
        px, py = self.find(x), self.find(y)
        
        if px == py:
            return False
        
        if self.rank[px] > self.rank[py]:
            self.parent[py] = px
            self.rank[px] += self.rank[py]
        else:
            self.parent[px] = py
            self.rank[py] += self.rank[px]
        
        return True

class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        uf = UnionFind(len(accounts))
        hashmap = {}
        candidates = {}
        ans = []
        
        for i, acc in enumerate(accounts):
            email = acc[1:]
            
            for e in email:
                if e not in hashmap:
                    hashmap[e] = i
                else:
                    uf.union(i, hashmap[e])
        
        for key, val in hashmap.items():
            leader = uf.find(val)
            
            if leader not in candidates:
                candidates[leader] = []
            
            candidates[leader].append(key)
        
        for key, val in candidates.items():
            
            user = [accounts[key][0]]
            emails = sorted(val)
            ans.append(user + emails)
        
        return ans
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            