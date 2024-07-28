class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj = [[] for _ in range(numCourses)]
        indegree = [0 for _ in range(numCourses)]
        
        for x, y in prerequisites:
            adj[y].append(x)
            indegree[x] += 1
        
        queue = []
        count = 0
        
        for i in range(len(indegree)):
            ind = indegree[i]
            if ind == 0:
                queue.append(i)
                count += 1
        
        while queue:
            node = queue.pop(0)
            
            for neighbor in adj[node]:
                indegree[neighbor] -= 1
                
                if indegree[neighbor] == 0:
                    queue.append(neighbor)
                    count += 1
            
        
        return count == numCourses
            