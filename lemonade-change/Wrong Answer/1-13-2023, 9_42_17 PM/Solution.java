// https://leetcode.com/problems/lemonade-change

class Solution {
    int[] change=new int[2];
    public boolean lemonadeChange(int[] bills) {
        int[] change= new int[3];
        if(bills[0]!=5){
            return false;
        }
        change[0]++;
        
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                change[0]++;
            }
            else if(bills[i]==10){
                if(change[0]>=1){
                    change[0]--;
                }
                else{
                    return false;
                }
            }
            else{
                if(change[0]>=1 &&  change[1]>=1){
                    change[0]--;
                    change[1]--;
                }
                else if(change[0]>=3){
                    change[0]-=3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}