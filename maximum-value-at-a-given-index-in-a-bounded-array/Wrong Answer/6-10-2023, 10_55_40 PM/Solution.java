// https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array

class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int start=0;
        int end=maxSum;
        int ans=-1;
        while(start<=end){
            int mid=(end-start)/2+start;
            if(check(index,n,maxSum,mid)){
                ans=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
    public boolean check(int index,int n,int maxSum,int mid){
        int rightsum=0;
        int emptyr=n-index-1;
        int emptyl=index;
        int el=mid-1;
        if(emptyr>el){
            rightsum=el*(el+1)/2+emptyr-el;
            
        }
        else{
            rightsum=el*(el+1)/2-(-emptyr+el)*(-emptyr+el+1)/2;

        }
        int leftsum=0;
        if(emptyl>el){
            leftsum=el*(el+1)/2+emptyl-el;

        }
        else{
            leftsum=el*(el+1)/2-(-emptyl+el)*(-emptyl+el+1)/2;

        }
   
        if(leftsum+rightsum+mid<=maxSum){
            return true;
        }
        return false;
    }
}