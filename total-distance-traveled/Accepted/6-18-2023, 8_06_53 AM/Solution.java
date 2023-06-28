// https://leetcode.com/problems/total-distance-traveled

class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        if(mainTank==1){
            return 10;
        }
        int cnt=0;
        int hehe=0;
        while(mainTank>0){
            hehe = hehe + 10;
            mainTank --;
            cnt ++;
            if(cnt == 5 && additionalTank > 0){
                cnt = 0;
                mainTank ++;
                additionalTank--;
            }
        }
        
        return hehe;
    }
}