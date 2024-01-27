class UnionFind:
    
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.rank = [1 for _ in range(n)]
    
    def find(self, x):
        while x != self.parent[x]:
            self.parent[x] = self.parent[self.parent[x]]
            x = self.parent[x]
        
        return x
    
    def union(self, x, y):
        px, py = self.find(x), self.find(y)
        
        if px == py:
            return False
        else:
            
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
        groups = {}
        ans = []
        
        for i, account in enumerate(accounts):
            emails = account[1:]
            
            for email in emails:
                if email not in hashmap:
                    hashmap[email] = i
                else:
                    uf.union(i, hashmap[email])
                    
        
        for key, val in hashmap.items():
            leader = uf.find(val)
            
            if leader not in groups:
                groups[leader] = []
            
            groups[leader].append(key)
        
        
        for key, val in groups.items():
            ans.append([accounts[key][0]] + sorted(val))
        
        
        return ans
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        