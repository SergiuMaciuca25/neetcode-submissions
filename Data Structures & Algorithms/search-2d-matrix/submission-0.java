class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] <= target && matrix[i][n - 1] >= target) {

                int left = 0;
                int right = n - 1;

                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    if (matrix[i][mid] < target) {
                        left = mid + 1;
                    } else if (matrix[i][mid] > target) {
                        right = mid - 1;
                    } else {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
