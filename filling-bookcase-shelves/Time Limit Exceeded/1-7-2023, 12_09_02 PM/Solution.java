// https://leetcode.com/problems/filling-bookcase-shelves

class Solution {
    public int minHeightShelves(int[][] books, int w){
       return help(books,0,w,w,0);
    }
    public int help(int[][] books,int i, int w,int rem,int height){
        if(i>=books.length){
            return height;

        }
        int ans=help(books,i+1,w,w-books[i][0],books[i][1])+height;
        if(books[i][0] <=rem){
            ans=Math.min(ans,help(books,i+1,w,rem-books[i][0],Math.max(height,books[i][1])));
        }
        return ans;



    }
}