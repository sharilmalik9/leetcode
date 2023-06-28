// https://leetcode.com/problems/find-the-most-competitive-subsequence



class Solution {
    public int[] mostCompetitive(int[] nums, int k) {

        Stack<Integer>st=new Stack<>();

        if(nums.length==k)
        {
            return nums;
        }
        int n=nums.length;
        
        for(int i=0;i<n;i++)
        {
            int rem=n-i;
            while(!st.isEmpty() && st.peek()>nums[i] && rem+st.size()-1>=k)
            {
                st.pop();

            }
            if(st.size()<k)
            {
                st.push(nums[i]);
            }    
        }
        int ans[]=new int[k];
        int i=k-1;
        while(!st.isEmpty())
        {
            ans[i--]=st.pop();
        }
        return ans;
        
    }
}


















