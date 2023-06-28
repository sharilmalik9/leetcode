// https://leetcode.com/problems/rectangle-area

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1=(ax2-ax1)*(ay2-ay1);
        int area2=(bx2-bx1)*(by2-by1);
        int minright=0;
        int maxleft=0;
        int mintop=0;
        int maxbottom=0;
        minright=Math.min(ax2,bx2);
        maxleft=Math.max(bx1,ax1);
        mintop=Math.min(ay2,by2);
        maxbottom = Math.max(ay1,by1);
        int xoverlap= minright-maxleft;
        int yoverlap=mintop-maxbottom;
        int overlaparea=0;
        if (xoverlap>0 && yoverlap>0)
        {
            overlaparea=xoverlap*yoverlap;
           
        }
        return area1+area2-overlaparea;
        
        
        
        
        
        
    }
}