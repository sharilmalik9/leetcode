// https://leetcode.com/problems/container-with-most-water

class Solution {
    public int maxArea(int[] heights) {
        int first=0;
        int last=heights.length-1;
        int area=0;
        while(first<last){
            area=Math.max(area,Math.min(heights[last],heights[first])*(last-first));
            if(heights[last]>heights[first]){
                first++;
            }
            else{
                last--;
}
            
}
        return area;
        
        
    }
}