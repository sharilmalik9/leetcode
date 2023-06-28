// https://leetcode.com/problems/largest-component-size-by-common-factor

class Solution {
    int[] parent;
    public int largestComponentSize(int[] nums) {
    
        Arrays.sort(nums);
        parent= new int[100001];
        for(int i=0;i<parent.length;i++){
             parent[i]=-1;
        }
        for(int i=0;i<nums.length;i++){
            for(int j=2;j<=nums[i]/2;j++){
                 if(nums[i]%j==0){
                     union(j,nums[i]);
                     union(nums[i],nums[i]/j);
                
            }
          }
        }
         
         int[] cnt= new int[parent.length];
         int ans=0;
         for(int i=0;i<nums.length;i++){
             ans=Math.max(ans,++cnt[find(nums[i])]);

         }
         return ans;
    }
    public int find(int x){
        if(parent[x]==-1){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
    public void union(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px==py){
            return;
        }
        parent[px]=py;
    }
}