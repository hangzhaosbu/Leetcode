class Solution {
    public boolean isPossible(int[] nums) {
        PriorityQueue<int[]> subsequences = new PriorityQueue<>((int[] subsequence1, int[] subsequence2) -> {
            if (subsequence1[1] == subsequence2[1]) {
                return (subsequence1[1] - subsequence1[0]) - (subsequence2[1] - subsequence2[0]);
            }
            return (subsequence1[1] - subsequence2[1]);
        });

        for (int num : nums) {
            // Condition 1 - remove non-qualifying subsequences 
            while (!subsequences.isEmpty() && subsequences.peek()[1] + 1 < num) {
                int[] currentSubsequence = subsequences.poll();
                int subsequenceLength = currentSubsequence[1] - currentSubsequence[0] + 1;
                if (subsequenceLength < 3) {
                    return false;
                }
            }
            //Condition 2 - create a new subsequence
            if (subsequences.isEmpty() || subsequences.peek()[1] == num) {
                subsequences.add(new int[]{num, num});
            } else {
                // Condition 3 - add num to an existing subsequence
                int[] currentSubsequence = subsequences.poll();
                subsequences.add(new int[]{currentSubsequence[0], num});
            }
        }

        // If any subsequence is of length less than 3, return false
        while (!subsequences.isEmpty()) {
            int[] currentSubsequence = subsequences.poll();
            int subsequenceLength = currentSubsequence[1] - currentSubsequence[0] + 1;
            if (subsequenceLength < 3) {
                return false;
            }
        }

        return true;
    }
}
