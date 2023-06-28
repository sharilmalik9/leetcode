// https://leetcode.com/problems/daily-temperatures

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> help= new Stack<>();
        if(temperatures.length==0){
            return null;
        }
        int[] ans= new int[temperatures.length];
        help.push(0);
        for(int i=1;i<temperatures.length;i++){
            while(!help.isEmpty()&&temperatures[help.peek()]<temperatures[i]){
                ans[help.peek()]=i-help.pop();
            }
            help.add(i);

        }
        while(!help.isEmpty()){
            ans[help.pop()]=0;
        }
        return ans;
        
    }
}