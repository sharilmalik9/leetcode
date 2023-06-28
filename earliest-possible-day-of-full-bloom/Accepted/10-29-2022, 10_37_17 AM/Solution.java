// https://leetcode.com/problems/earliest-possible-day-of-full-bloom

class Solution {
    class pair{
        int plant;
        int grow;
        pair(int plant,int grow){
            this.plant=plant;
            this.grow=grow;
        }
    }
    public int earliestFullBloom(int[] plantTime, int[] growTime){
        pair[] arr= new pair[plantTime.length];
        for(int i=0;i<plantTime.length;i++){
            pair pp= new pair(plantTime[i],growTime[i]);
            arr[i]=pp;
            
        }
        Arrays.sort(arr,(a,b)->b.grow-a.grow);
        int res=0;
        int curr=0;
        for(pair i: arr){
             curr+=i.plant;
            res=Math.max(res,curr+i.grow);
        }
        
        return res;
        
    }
}