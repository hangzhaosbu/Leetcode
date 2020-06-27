"""
本代码来自 CSON 官方视频课程，由 @CSON 提供
题目来源：http://leetcode.com
- CSON 致力于在 CS 领域内帮助中国人找到工作，让更多海内外国人受益
- 讲师：Edward Shi
- 官方网站：https://cspiration.com
- 版权归 CSON 所有，转发请注明出处
"""


class _310_MinimumHeightTrees:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        result = []
        if n == 1:
            result.append(0)
            return result
        adj = [[] for _ in range(n)]
        for edge in edges:
            adj[edge[0]].append(edge[1])
            adj[edge[1]].append(edge[0])
        for i in range(n):
            if len(adj[i]) == 1:
                result.append(i)
        while n > 2:
            n -= len(result)
            leaves = []
            for i in result:
                for j in adj[i]:
                    adj[j].remove(i)
                    if len(adj[j]) == 1:
                        leaves.append(j)
            result = leaves
        return result
