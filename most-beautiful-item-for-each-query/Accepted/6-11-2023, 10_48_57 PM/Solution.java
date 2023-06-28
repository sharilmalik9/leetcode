// https://leetcode.com/problems/most-beautiful-item-for-each-query

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items,(a,b)->a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        int[] maxprice=new int[items.length];
        int max=items[0][1];
        maxprice[0]=max;
        for(int i=1;i<items.length;i++){
            maxprice[i]=Math.max(max,items[i][1]);
            max=Math.max(max,maxprice[i]);
        }

        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int idx=help(queries[i],items);
            if(idx==-1){
                ans[i]=0;
                continue;
            }
            ans[i]=maxprice[idx];
        }
        return ans;
    }
    public int help(int item,int[][] items){
        int start=0;
        int end=items.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(items[mid][0]<=item){
                ans=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }

        return ans;
    }
}