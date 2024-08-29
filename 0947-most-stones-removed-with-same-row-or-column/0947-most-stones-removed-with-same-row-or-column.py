class Solution:
    def removeStones(self, stones: List[List[int]]) -> int:
        n = len(stones)

        # Adjacency list to store graph connections
        adjacency_list = [[] for _ in range(n)]

        # Build the graph: Connect stones that share the same row or column
        for i in range(n):
            for j in range(i + 1, n):
                if stones[i][0] == stones[j][0] or stones[i][1] == stones[j][1]:
                    adjacency_list[i].append(j)
                    adjacency_list[j].append(i)

        num_of_connected_components = 0
        visited = [False] * n

        # DFS to visit all stones in a connected component
        def _depth_first_search(stone):
            visited[stone] = True
            for neighbor in adjacency_list[stone]:
                if not visited[neighbor]:
                    _depth_first_search(neighbor)

        # Traverse all stones using DFS to count connected components
        for i in range(n):
            if not visited[i]:
                _depth_first_search(i)
                num_of_connected_components += 1

        # Maximum stones that can be removed is total stones minus number of connected components
        return n - num_of_connected_components