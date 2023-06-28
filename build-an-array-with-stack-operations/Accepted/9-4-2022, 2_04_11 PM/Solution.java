// https://leetcode.com/problems/build-an-array-with-stack-operations

class Solution {
    public List<String> buildArray(int[] target, int n) {
        Stack<Integer> stream= new Stack<>();
        Stack<String> op= new Stack<>();
        int idx=0;
        int currStream=1;
        while(idx<target.length && currStream<n+1){
            stream.push(currStream);
             op.push("Push");
            if(currStream==target[idx]){
                idx++;
                currStream++;
               // op.push("Push");
                
            }
            else{
                stream.pop();
                currStream++;
                op.push("Pop");
                 }
        }
        List<String> ans= new ArrayList<>();
        while(op.size()!=0){
            ans.add(op.pop());
        }
        Collections.reverse(ans);
        return ans;
    }
    
}