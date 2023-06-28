// https://leetcode.com/problems/successful-pairs-of-spells-and-potions

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n=potions.length;
        int[] ans= new int[spells.length];
        for(int i=0;i<spells.length;i++){
            int idx=find(spells[i],potions,success);
            System.out.println(idx);
            ans[i]=n-idx;
            if(idx==0){
                ans[i]=0;
            }
        }
        
      return ans;
    }
    public int find(long target,int[] arr,long success){
        int start=0;
        int end=arr.length-1;
        int ans=0;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]*target==success){
                return mid;
            }
            if(arr[mid]*target>success){
                ans=mid;
                end=mid-1;
            }
            else{
               start=mid+1;
            }
        }
        return ans;



    }
}