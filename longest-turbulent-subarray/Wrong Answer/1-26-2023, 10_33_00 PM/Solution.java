// https://leetcode.com/problems/longest-turbulent-subarray

class Solution {
    public int maxTurbulenceSize(int[] arr) {
        boolean curr=false;
        boolean next=false;
        int ans=0;
      
        int start=0;
        int end=2;

        if(arr.length==1){
            return 1;
        }
        if(arr.length==2){
            if(arr[0]==arr[1]){
                return 1;
            }
            return 2;
        }
        if(arr[0]>arr[1]){
            curr=true;
        }
      


        while(end<arr.length){
            if(arr[end-1]>arr[end]){
                next=true;
            }
            else{
                next=false;
            }
            if(curr==next){
                ans=Math.max(ans,end-start);
                 if(arr[end-1]==arr[end]){
                     start=end;
                    
                }
                else{
                    start=end-1; 
                }
                
               
                
            }
            end++;
            curr=next;


        }
        return ans;

     
    }
}