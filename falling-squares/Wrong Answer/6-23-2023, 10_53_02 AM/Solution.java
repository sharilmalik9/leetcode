// https://leetcode.com/problems/falling-squares

class Solution {
    public List<Integer> fallingSquares(int[][] positions){
        int[][] arr=new int[positions.length][3];
        for(int i=0;i<positions.length;i++){
            arr[i][0]=positions[i][0];
            arr[i][1]=positions[i][0]+positions[i][1];
            arr[i][2]=positions[i][1];
        }
        List<Integer> ans=new ArrayList<>();
        int max=0;
        Arrays.sort(arr,(a,b)->a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
       for(int i=0;i<arr.length;i++){
           int start=arr[i][0];
           int end=arr[i][1];
           int height=arr[i][2];
           while(pq.size()!=0 && pq.peek()[0]<=start){
               pq.poll();
           }
          
           while(pq.size()!=0 && pq.peek()[0]>start){
               height+=pq.poll()[1];
           }
           max=Math.max(max,height);
           ans.add(max);
           pq.add(new int[] {end,height});

       }
       return ans;
        
    }
}