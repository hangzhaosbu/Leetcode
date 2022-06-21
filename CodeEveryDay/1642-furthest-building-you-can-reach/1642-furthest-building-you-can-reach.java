class Solution {
    
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int lo = Integer.MAX_VALUE;
        int hi = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length - 1; i++) {
            int climb = heights[i + 1] - heights[i];
            if (climb <= 0) {
                continue;
            }
            lo = Math.min(lo, climb);
            hi = Math.max(hi, climb);   
        }
        if (lo == Integer.MAX_VALUE) {
            return heights.length - 1;
        }
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int[] result = solveWithGivenThreshold(heights, bricks, ladders, mid);
            int indexReached = result[0];
            int laddersRemaining = result[1];
            int bricksRemaining = result[2];
            if (indexReached == heights.length - 1) {
                return heights.length - 1;
            }
            if (laddersRemaining > 0) {
                hi = mid - 1;
                continue;
            }
            // Otherwise, check whether this is the "too low" or "just right" case.
            int nextClimb = heights[indexReached + 1] - heights[indexReached];
            if (nextClimb > bricksRemaining && mid > bricksRemaining) {
                return indexReached;
            } else {
                lo = mid + 1;
            }
        }
        return -1; // It always returns before here. But gotta keep Java happy.
    }
    
    public int[] solveWithGivenThreshold(int[] heights, int bricks, int ladders, int K) {
        int laddersUsedOnThreshold = 0;
        for (int i = 0; i < heights.length - 1; i++) {
            int climb = heights[i + 1] - heights[i];
            if (climb <= 0) {
                continue;
            }
            // Make resource allocations
            if (climb == K) {
                laddersUsedOnThreshold++;
                ladders--;
            } else if (climb > K) {
                ladders--;
            } else {
                bricks -= climb;
            }
            // Handle negative resources
            if (ladders < 0) {
                if (laddersUsedOnThreshold >= 1) {
                    laddersUsedOnThreshold--;
                    ladders++;
                    bricks -= K;
                } else {
                    return new int[]{i, ladders, bricks};
                }
            }
            if (bricks < 0) {
                return new int[]{i, ladders, bricks};
            }
        }
        return new int[]{heights.length - 1, ladders, bricks};
    }
}