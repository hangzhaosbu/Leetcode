class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges) != n - 1:
            return False
        
        adj = [[] for _ in range(n)]
        visited = [False for _ in range(n)]
        
        for x, y in edges:
            adj[x].append(y)
            adj[y].append(x)
        
        
        
        queue = [0]
        visited[0] = True
        
        while queue:
            node = queue.pop(0)
            
            for neighbor in adj[node]:
                if not visited[neighbor]:
                    visited[neighbor] = True
                    queue.append(neighbor)
        
        
        return sum(visited) == n