// https://leetcode.com/problems/construct-quad-tree

class Solution {
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length - 1, grid[0].length - 1);
    }
    
    private Node construct(int[][] grid, int rowStart, int colStart, int rowEnd, int colEnd) {
        if (rowStart > rowEnd || colStart > colEnd) {
            return null;
        }
        boolean isLeaf = true;
        int val = grid[rowStart][colStart];
        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                if (grid[i][j] != val) {
                    isLeaf = false;
                    break;
                }
            }
        }
        if (isLeaf) {
            return new Node(val == 1, true, null, null, null, null);
        }
        int rowMid = (rowStart + rowEnd) / 2;
        int colMid = (colStart + colEnd) / 2;
        Node topLeft = construct(grid, rowStart, colStart, rowMid, colMid);
        Node topRight = construct(grid, rowStart, colMid + 1, rowMid, colEnd);
        Node bottomLeft = construct(grid, rowMid + 1, colStart, rowEnd, colMid);
        Node bottomRight = construct(grid, rowMid + 1, colMid + 1, rowEnd, colEnd);
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}