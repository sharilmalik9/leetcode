// https://leetcode.com/problems/number-of-visible-people-in-a-queue

class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int[] ans= new int[heights.length];
        ans[heights.length-1]=0;
        st.push(heights.length-1);
        for(int i=heights.length-2;i>=0;i--){
            int vis=0;
            while(st.size()!=0 && heights[i]>heights[st.peek()]){
                st.pop();
                vis++;
                
            }
            if(st.size()!=0){
                vis++;
            }
            ans[i]=vis;
            st.push(i);
        }
        return ans;
    }
}