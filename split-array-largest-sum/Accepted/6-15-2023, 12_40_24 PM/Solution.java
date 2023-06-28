// https://leetcode.com/problems/split-array-largest-sum

class Solution {
    public int splitArray(int[] nums, int k){
        int sum=nums[0];
        
        int[] prefix=new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=nums[i]+prefix[i-1];
            sum+=nums[i];
        }
        if(k==1){
            return sum;
        }
        int ans=0;
        int start=0;
        int end=sum;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(check(prefix,k,mid)){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        } 
        return ans;
    }
    public boolean check(int[] prefix,int k,int mid){
      
        int start=-1;
        int cnt=0;
        if(prefix[0]>mid){
            return false;
        }
        for(int i=0;i<prefix.length;i++){
            if(i!=0 && prefix[i]-prefix[i-1]>mid){
                return false;
            }

            if(start!=-1 && prefix[i]-prefix[start]>mid){
                cnt++;
                start=i-1;
            }
            if(start==-1 && prefix[i]>mid){
                start=i-1;
                cnt++;
            }
            if(cnt==k-1){
               break;
            }

        }
        // if(cnt<k-1){
        //     return false;
        // }
        if(start!=-1 && prefix[prefix.length-1]-prefix[start]<=mid){
            
            return true;

        }
        return false;
    }
}