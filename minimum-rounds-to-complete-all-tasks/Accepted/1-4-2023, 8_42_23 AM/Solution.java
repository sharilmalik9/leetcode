// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks

class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int index=0;
        int rounds=0;
        while(index<tasks.length){
            int cnt=1;
            while(index<tasks.length-1 && tasks[index]==tasks[index+1]){
                cnt++;
                index++;

            }
            if(cnt==1 ){
                return -1;
            }
            rounds+=give(cnt);
            index++;
        }




        return rounds;
        
    }
    public int give(int val){
       if(val==2 || val==3){
           return 1;
       }
       else if(val%3==0){
          
          return val/3;
       }
       else if(val%3==1){
           return val/3+1;

       }
       else{
           return val/3+1;

       }

    }
}