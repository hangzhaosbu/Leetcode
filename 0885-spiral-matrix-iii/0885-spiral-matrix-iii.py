class Solution:
    def spiralMatrixIII(
        self, rows: int, cols: int, rStart: int, cStart: int
    ) -> List[List[int]]:
        # Store all possible directions in an array.
        dir = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        traversed = []

        # Initial step size is 1, value of d represents the current direction.
        step = 1
        direction = 0
        while len(traversed) < rows * cols:
            # direction = 0 -> East, direction = 1 -> South
            # direction = 2 -> West, direction = 3 -> North
            for _ in range(2):
                for _ in range(step):
                    # Validate the current position
                    if (
                        rStart >= 0
                        and rStart < rows
                        and cStart >= 0
                        and cStart < cols
                    ):
                        traversed.append([rStart, cStart])
                    # Make changes to the current position.
                    rStart += dir[direction][0]
                    cStart += dir[direction][1]

                direction = (direction + 1) % 4
            step += 1
        return traversed