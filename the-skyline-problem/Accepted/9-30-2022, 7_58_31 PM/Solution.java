// https://leetcode.com/problems/the-skyline-problem

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans= new ArrayList<>();
        List<int[]> ls= new ArrayList<>();
        for(int[] i:buildings){
            ls.add(new int[]{i[0],-i[2]});
            ls.add(new int[]{i[1],i[2]});
            
        }
        Collections.sort(ls,(a,b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
        pq.add(0);
        int max=0;
        for(int[] pair:ls){
            if(pair[1]<0){
                pq.offer(-pair[1]);
            }
            else{
                pq.remove(pair[1]);
            }
            int curr=pq.peek();
            if(max!=curr){
                List<Integer> ansarr=new ArrayList<>();
                ansarr.add(pair[0]);
                ansarr.add(curr);
                max=curr;
                ans.add(ansarr);
            }
        }
        return ans;
    }
}