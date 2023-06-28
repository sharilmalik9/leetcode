// https://leetcode.com/problems/maximize-distance-to-closest-person

class Solution {
    public int maxDistToClosest(int[] seats) {
        int idx=0;
        int ans=1;
        while(idx<seats.length){
            if(seats[idx]==0){
                int right=idx;
                int cnt=0;
                while(right<seats.length && seats[right]==0){
                    
                    right++;
                    cnt++;
                }
                if(idx==0 || right == seats.length){
                    ans=Math.max(ans,cnt);
                }
                else{
                    if(cnt%2!=0){
                         ans=Math.max(ans,cnt/2+1);

                    }
                    else{
                        ans=Math.max(ans,cnt);
                    }
                   
                }
                idx=right+1;

            }
            else{
                idx++;
            }
        }
        return ans;

    }
}