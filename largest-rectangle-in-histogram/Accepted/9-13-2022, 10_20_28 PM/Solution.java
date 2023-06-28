// https://leetcode.com/problems/largest-rectangle-in-histogram

class Solution {
    public int largestRectangleArea(int[] heights) {
    int[] rb = new int[heights.length];
    Stack<Integer> st = new Stack<>();
        
    st.push(heights.length-1);
    rb[heights.length-1] = heights.length;
        
    for(int i=heights.length-2;i>=0;i--){
       while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
          st.pop();
       }
       rb[i]= st.isEmpty()?heights.length:st.peek();
       st.push(i);
    }

    int[] lb = new int[heights.length];
    st = new Stack<>();
        
    st.push(0);
    lb[0] = -1;
        
    for(int i=1;i<heights.length;i++){
       while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
          st.pop();
       }
       lb[i]= st.isEmpty()?-1:st.peek();
       st.push(i);
    }
        
    int maxArea = 0;
        
    for(int i=0;i<heights.length;i++){
       int width = rb[i] - lb[i] -1;
       int area = width*heights[i];
       if(area>maxArea){
          maxArea=area;
       }
    }
        return maxArea;
  }
}