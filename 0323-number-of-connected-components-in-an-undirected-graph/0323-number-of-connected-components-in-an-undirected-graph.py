class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        count = 0
        
        visited = [False for _ in range(n)]
        adj = [[] for _ in range(n)]
        
        for x, y in edges:
            adj[x].append(y)
            adj[y].append(x)
        
        for i in range(n):
            
            if not visited[i]:
                visited[i] = True
                count += 1
                
                queue = [i]
                
                while queue:
                    node = queue.pop(0)
                    
                    for neighbor in adj[node]:
                        if not visited[neighbor]:
                            visited[neighbor] = True
                            queue.append(neighbor)
        
        return count
                
        
        