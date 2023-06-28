// https://leetcode.com/problems/minimum-speed-to-arrive-on-time

class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int sum=0;
        for(int i:dist){
            sum+=i;
        }
        if((double)sum==hour){
            return 1;
        }
        int end=sum;
        int start=0;
        int ans=-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(check(dist,mid,hour)){
             
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }

        }
        return ans;

    }
    public boolean check(int[] dist,int mid,double hour){
        double ans=0;
        for(int i=0;i<dist.length-1;i++){
            
            ans+=(double)Math.ceil((double)dist[i]/mid);
            

        }
        ans+=(double)((double)dist[dist.length-1]/mid);
        if(ans<=hour){
            return true;
        }
        return false;


    }
}