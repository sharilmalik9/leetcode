// https://leetcode.com/problems/minimum-time-to-make-rope-colorful

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int time=0;
        for(int i=1;i<colors.length();i++){
            if(colors.charAt(i)==colors.charAt(i-1)){
                if(neededTime[i-1]<neededTime[i]){
                    time+=neededTime[i-1];
                    neededTime[i-1]=neededTime[i];
                }
                else{
                    time+=neededTime[i];
                    neededTime[i]=neededTime[i-1];
                }
}
            
        }
        return time;
        
    }
}