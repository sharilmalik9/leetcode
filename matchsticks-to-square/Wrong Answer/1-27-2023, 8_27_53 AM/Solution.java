// https://leetcode.com/problems/matchsticks-to-square

class Solution {
    public boolean makesquare(int[] matchsticks){
        int sum=0;
        for(int i: matchsticks){
            sum+=i;
        }
        if(sum%4!=0){
            return false;
        }
        sum=sum/4;
        Arrays.sort(matchsticks);
        int currsum=0;
        int count=0;
        for(int i=0;i<matchsticks.length;i++){
            currsum+=matchsticks[i];
            if(sum==currsum){
                count++;
                currsum=0;
            }
        }
        return count==4 ? true : false;
        
    }
}