// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero

class Solution {
    public int minOperations(int[] nums, int x) {
        int[] front=new int[nums.length];
        int[] back=new int[nums.length];
        front[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            front[i]=front[i-1]+nums[i];
        }
        back[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            back[i]=back[i+1]+nums[i];
        }
        int ans=Integer.MAX_VALUE;
        int idx=0;
        System.out.println(ans);
        while(idx<nums.length){
            if(front[idx]==x){
                ans=idx+1;
                break;
            }
            idx++;
        }
        idx=nums.length-1;
        while(idx>=0){
            if(back[idx]==x){
                ans=Math.min(ans,nums.length-idx);
                break;
            }
            idx--;
        }       
        int start=0;
        while(start<nums.length){     
            if(x-front[start]<=0){
                break;
            }
            int he=check(x-front[start],back);
            
            if(he==-1 || he<=start){
                start++;
                continue;
            }
            ans=Math.min(ans,start+1+nums.length-he);
            start++;
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;        
    }
    public int check(int element,int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
                            System.out.println(element);

            int mid=start+(end-start)/2;
            if(arr[mid]==element){

                return mid;

            }
            if(arr[mid]<element){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
}