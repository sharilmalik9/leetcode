// https://leetcode.com/problems/sort-the-matrix-diagonally

class Solution {
    public int[][] diagonalSort(int[][] mat){
        int m=mat.length;
        int n=mat[0].length;
        for(int i=0;i<m;i++){
            sort(mat,i,0,m,n);
        }
        for(int i=1;i<n;i++){
            sort(mat,0,i,m,n);
        }
        return mat; 
    }
    public void sort(int[][] mat,int row,int col,int m,int n){
        List<Integer> ls= new ArrayList<>();
        int r=row;
        int c=col;
        while(r<m && c<n){
            ls.add(mat[r][c]);
            r++;
            c++;
        }
        r=row;
        c=col;
        Collections.sort(ls);
        int idx=0;
        while(r<m && c<n){
            mat[r][c]=ls.get(idx);
            r++;
            c++;
            idx++;
        }

    }
}