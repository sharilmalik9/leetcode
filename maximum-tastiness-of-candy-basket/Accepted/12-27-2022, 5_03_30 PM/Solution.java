// https://leetcode.com/problems/maximum-tastiness-of-candy-basket

class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int ans=0;
        int start=0;
        int end=price[price.length-1]-price[0];
        while(start<=end){
            int mid=(end+start)/2;
            System.out.println(mid);
            if(check(price,k,mid)){
                ans=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
        public boolean check(int[] price,int k, int mid){
            int prev=price[0];
            for(int i=1;i<price.length;i++){
                if(k==1) break;
                if(price[i]-prev>=mid){
                    k--;
                    prev=price[i];
                }
            }
       return k==1; 
    }
}