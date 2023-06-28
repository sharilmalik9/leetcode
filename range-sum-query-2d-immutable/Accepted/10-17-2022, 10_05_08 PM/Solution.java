// https://leetcode.com/problems/range-sum-query-2d-immutable

class NumMatrix {
    int matrix[][];
    public NumMatrix(int[][] matrix) {
        
        for(int i = 0; i < matrix.length; i++)
        {
            int sum = 0;
            for(int j = 0; j < matrix[i].length; j++)
            {
                sum = sum + matrix[i][j];
                matrix[i][j] = sum;
            }
        }
        
        for(int j = 0; j < matrix[0].length; j++)
        {
            int sum = 0;
            for(int i = 0; i < matrix.length; i++)
            {
                sum = sum + matrix[i][j];
                matrix[i][j] = sum;
            }
        }
                
        this.matrix = matrix;
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
         
        int ans = matrix[row2][col2];
        if(row1 - 1 >= 0)
        {
            ans = ans - matrix[row1 - 1][col2];
        }
        if(col1 - 1 >= 0)
        {
            ans = ans - matrix[row2][col1 - 1];
        }
        if(row1 - 1 >= 0 && col1 - 1 >= 0)
        {
            ans = ans + matrix[row1 - 1][col1 -1];
        }
        return ans;
    }
}