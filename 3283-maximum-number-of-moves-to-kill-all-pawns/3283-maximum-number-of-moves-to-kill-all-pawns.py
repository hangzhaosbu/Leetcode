class Solution:
    def maxMoves(self, kx: int, ky: int, positions: List[List[int]]) -> int:
        P = len(positions)
        positions.append([kx, ky])  # Append knight's initial position
        N = P + 1
        positions_index = { (positions[i][0], positions[i][1]): i for i in range(N) }
        initial_pos_index = P  # Knight's initial position index

        # Precompute distances between positions using BFS
        distances = [[-1] * N for _ in range(N)]
        for i in range(N):
            x0, y0 = positions[i]
            visited = [[-1] * 50 for _ in range(50)]
            queue = deque()
            queue.append((x0, y0))
            visited[x0][y0] = 0
            while queue:
                x, y = queue.popleft()
                d = visited[x][y]
                if (x, y) in positions_index:
                    j = positions_index[(x, y)]
                    distances[i][j] = d
                # Possible moves of a knight
                for dx, dy in [(-2, -1), (-2, 1), (-1, -2), (-1, 2),
                               (1, -2), (1, 2), (2, -1), (2, 1)]:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < 50 and 0 <= ny < 50 and visited[nx][ny] == -1:
                        visited[nx][ny] = d + 1
                        queue.append((nx, ny))

        @lru_cache(maxsize=None)
        def dp(current_pos_index: int, pawns_mask: int, player: int) -> int:
            if pawns_mask == 0:
                return 0  # No more pawns to capture
            if player == 0:  # Alice's turn (maximizing player)
                max_total = float('-inf')
                for i in range(P):
                    if pawns_mask & (1 << i):
                        cost = distances[current_pos_index][i]
                        if cost == -1:
                            continue  # Pawn is unreachable
                        new_pawns_mask = pawns_mask & ~(1 << i)
                        total = cost + dp(i, new_pawns_mask, 1)
                        max_total = max(max_total, total)
                return max_total
            else:  # Bob's turn (minimizing player)
                min_total = float('inf')
                for i in range(P):
                    if pawns_mask & (1 << i):
                        cost = distances[current_pos_index][i]
                        if cost == -1:
                            continue  # Pawn is unreachable
                        new_pawns_mask = pawns_mask & ~(1 << i)
                        total = cost + dp(i, new_pawns_mask, 0)
                        min_total = min(min_total, total)
                return min_total

        initial_pawns_mask = (1 << P) - 1  # All pawns are initially present
        result = dp(initial_pos_index, initial_pawns_mask, 0)
        return result