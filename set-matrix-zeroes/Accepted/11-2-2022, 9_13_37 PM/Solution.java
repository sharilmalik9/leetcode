// https://leetcode.com/problems/set-matrix-zeroes

class Solution {

    List<Integer> rowsWithZero = new ArrayList<Integer>();
    List<Integer> columnsWithZero = new ArrayList<Integer>();


    public void setZeroes(int[][] matrix) {
        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix[i].length ; j++) {
                if(matrix[i][j] == 0) {
                    rowsWithZero.add(i);
                    columnsWithZero.add(j);
                }
            }
        }
        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix[i].length ; j++) {
                if(rowsWithZero.contains(i) || columnsWithZero.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}