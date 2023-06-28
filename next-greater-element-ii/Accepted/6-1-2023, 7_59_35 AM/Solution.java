// https://leetcode.com/problems/next-greater-element-ii

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st= new Stack<>();
        int n=nums.length;
        int[] ans= new int[nums.length];
        Arrays.fill(ans,Integer.MAX_VALUE);
        for(int i=0;i<2*nums.length;i++){
            while(st.size()!=0 && nums[st.peek()%n]<nums[i%n]){
                ans[st.pop()%n]=nums[i%n];
            }
            st.add(i);
            
        }
        while(st.size()!=0 ){
            if(ans[st.peek()%n]==Integer.MAX_VALUE){
                 ans[st.pop()%n]=-1;
}
            else{
                st.pop();
            }
        }
        return ans;
    }
}
// public int[] nextGreaterElements(int[] nums) {
//     int arr[] = new int[nums.length];
//     int n=nums.length;
//     Stack<Integer> stack = new Stack<>();
//     stack.push(-1);
//     for(int i=2*n-1;i>=0;i--)
//     {
//         while(stack.peek()<=nums[i%n]&&stack.size()>1)
//         {
//             if(stack.size()>1)
//             {
//                 stack.pop();
//             }
//         }
//         arr[i%n]=stack.peek();
//         stack.push(nums[i%n]);
//     }
//       return arr;   
// }