// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length){
            return -1;
        }
        int start=bloomDay[0];
        int end=bloomDay[0];
        for(int i: bloomDay){
            start=Math.min(i,start);
            end=Math.max(i,end);
            
        }
        while(start<end){
            int mid=start + (end - start) / 2;
            if(check(bloomDay,m,k,mid)){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }
    public boolean check(int[] bloomDay,int m,int k,int mid){
          int cc=0;
        for(int i=0;i<bloomDay.length;i++){
          
            if(bloomDay[i]>mid){
                cc=0;
            }
            else{
               cc++; 
            
            if(cc==k){
                m--;
                cc=0;
            }
            }
            
        }
        
        
        return m <= 0;
    }
}