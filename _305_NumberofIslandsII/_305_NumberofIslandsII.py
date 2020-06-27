"""
本代码来自 CSON 官方视频课程，由 @CSON 提供
题目来源：http://leetcode.com
- CSON 致力于在 CS 领域内帮助中国人找到工作，让更多海内外国人受益
- 讲师：Edward Shi
- 官方网站：https://cspiration.com
- 版权归 CSON 所有，转发请注明出处
"""


class _305_NumberofIslandsII:
    class UnionFind:
        parent = None

        def __init__(self, m: int, n: int) -> None:
            self.parent = [0 for _ in range(m * n)]
            for i in range(len(self.parent)):
                self.parent[i] = i

        def find(self, x: int) -> int:
            temp = x
            while x != self.parent[x]:
                x = self.parent[x]
            self.parent[temp] = x
            return x

        def union(self, x: int, y: int) -> None:
            root_x = self.find(x)
            root_y = self.find(y)
            if root_x != root_y:
                self.parent[root_x] = root_y

    def convertid(self, x: int, y: int, n: int) -> int:
        return x * n + y

    def numIslands2(self, m: int, n: int, positions: List[List[int]]) -> List[int]:
        result = []
        if m <= 0 or n <= 0: return result
        count = 0
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        island = [[0 for _ in range(n)] for _ in range(m)]
        union = self.UnionFind(m, n)
        for position in positions:
            x = position[0]
            y = position[1]
            old_id = self.convertid(x, y, n)
            if island[x][y] == 0:
                count += 1
                island[x][y] = 1
                for direction in directions:
                    new_x = x + direction[0]
                    new_y = y + direction[1]
                    new_id = self.convertid(new_x, new_y, n)
                    if 0 <= new_x < m and 0 <= new_y < n and island[new_x][new_y] == 1:
                        old_id_root = union.find(old_id)
                        new_id_root = union.find(new_id)
                        if old_id_root != new_id_root:
                            union.union(old_id_root, new_id_root)
                            count -= 1
            result.append(count)
        return result
