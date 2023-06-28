// https://leetcode.com/problems/next-greater-element-iv

class Solution {
    class pair{
        int idx;
        int cnt;
        public pair(int idx,int cnt){
            this.idx=idx;
            this.cnt=cnt;
        }

    }
    public int[] secondGreaterElement(int[] nums){
        Stack<pair> st=new Stack<>();
        int idx=0;
        int[] ans=new int[nums.length];
        while(idx<nums.length){
            Stack<pair> curr=new Stack<>();
            while(st.size()!=0 && nums[st.peek().idx]<nums[idx]){
                curr.add(st.pop());
            }
            st.add(new pair(idx,0));
            while(curr.size()!=0){
                if(curr.peek().cnt+1==2){
                    ans[curr.pop().idx]=nums[idx];
                }
                else{
                    curr.peek().cnt++;
                    st.add(curr.pop());
                }
            }
            idx++;
        }
        while(st.size()!=0){
            ans[st.pop().idx]=-1;
        }
        return ans;

    }
}