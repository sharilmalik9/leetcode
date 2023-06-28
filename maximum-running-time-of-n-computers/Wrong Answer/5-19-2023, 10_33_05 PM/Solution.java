// https://leetcode.com/problems/maximum-running-time-of-n-computers

class Solution {
    public long maxRunTime(int n, int[] batteries) {
        
        long sum = 0;
        for(int ele : batteries){
            sum += ele;
        }
        
        long ans = 0;
        long start = 0;
        long end = sum;
        
        while(start <= end){
            long avg = (start + end)/2;
            
            if(isPos(avg , n , batteries)){
                ans = avg;
                start = avg + 1;
            }else{
                end = avg - 1;
            }
        }
        
        return ans;
        
    }
    
    public boolean isPos(long avg , int n, int[] batteries){
        long sum = 0;
        for(int ele : batteries){
            sum+=ele;
            // if(ele < avg){
            //     sum += ele;
            // }else{
            //     sum += avg;
            // }
        }
        
        return sum >= avg*n;
        
    }
}