// https://leetcode.com/problems/sort-the-students-by-their-kth-score

class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score,( a, b)->
        -a[k]+b[k]
        );
        return score;
        
    }
}