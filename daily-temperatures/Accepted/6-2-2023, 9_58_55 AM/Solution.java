// https://leetcode.com/problems/daily-temperatures

class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] ans = new int[temp.length];
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<temp.length;i++){
            if(st.size()==0){
                st.push(i);
            }
            else if (temp[i]<temp[st.peek()]){
                st.push(i);
            }
            else{
                while(st.size()!=0 && temp[st.peek()]<temp[i]){
                    ans[st.peek()]=i-st.pop();

                }
                st.push(i);
            }
        }
        return ans;
    }
}