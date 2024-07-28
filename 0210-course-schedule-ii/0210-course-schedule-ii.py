class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        adj = [[] for _ in range(numCourses)]
        indegree = [0 for _ in range(numCourses)]
        
        for x, y in prerequisites:
            adj[y].append(x)
            indegree[x] += 1
        
        queue = []
        ret = []
        
        for i in range(len(indegree)):
            ind = indegree[i]
            if ind == 0:
                queue.append(i)
                ret.append(i)
        
        while queue:
            node = queue.pop(0)
            
            for neighbor in adj[node]:
                indegree[neighbor] -= 1
                
                if indegree[neighbor] == 0:
                    queue.append(neighbor)
                    ret.append(neighbor)
            
        
        return ret if len(ret) == numCourses else []