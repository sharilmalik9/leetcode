// https://leetcode.com/problems/maximum-white-tiles-covered-by-a-carpet

class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles,(a,b)->a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        int sum=0;
        int ans=0;
        Queue<int[]> que=new LinkedList<>();
        for(int i=0;i<tiles.length;i++){
            int[] curr=tiles[i];
            sum+=curr[1]-curr[0]+1;
            que.add(curr);
            while(que.size()!=0 && que.peek()[1]<=curr[1]-carpetLen){
                int[] tileremoved=que.poll();
                sum=sum-(tileremoved[1]-tileremoved[0]+1);
            }
            int covertillhere=sum-Math.max(0,curr[1]-carpetLen-que.peek()[0]+1);
            ans=Math.max(ans,covertillhere);

        }
        return ans;
        
    }
}