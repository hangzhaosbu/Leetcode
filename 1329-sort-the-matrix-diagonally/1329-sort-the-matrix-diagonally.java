class Solution {
    
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        for (int row = 0; row < m; row++) {
            sortDiagonal(row, 0, mat);
        }

        for (int col = 1; col < n; col++) {
            sortDiagonal(0, col, mat);
        }

        return mat;
    }

    private List<Integer> countingSort(List<Integer> nums) {
        // The problem constraints allow us to assume that
        // 1 <= mat[i][j] <= 100.
        // You should, however, confirm with the interviewer
        // that it is OK to hardcode values like this.
        int min = 1; // You could also use: Collections.min(nums); 
        int max = 100; // You could also use: Collections.max(nums);
        
        // Calculate the range of values, and then create a list
        // of the size of the range.
        int len = max - min + 1;
        int[] count = new int[len];
        // Tally up the values in nums.
        for (int num : nums) {
            count[num - min]++;
        }

        // Flatten the list of counts into a sorted list.
        List<Integer> sortedNums = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int times = count[i]; times > 0; times--) {
                sortedNums.add(i + min);
            }
        }

        return sortedNums;
    }

    private void sortDiagonal(int row, int col, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        List<Integer> diagonal = new ArrayList<>();

        int diagonalLength = Math.min(m - row, n - col);
        for (int i = 0; i < diagonalLength; i++) {
            diagonal.add(mat[row + i][col + i]);
        }

        // Sort the diagonal using our counting sort method.
        diagonal = countingSort(diagonal);

        for (int i = 0; i < diagonalLength; i++) {
            mat[row + i][col + i] = diagonal.remove(0);
        }
    }
}