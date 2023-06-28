// https://leetcode.com/problems/ipo

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] ls= new int[profits.length][2];
        for(int i=0;i<profits.length;i++){
            ls[i][0]=capital[i];
            ls[i][1]=profits[i];
        }
        Arrays.sort(ls,(i,j)-> i[0]-j[0]);
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        int i=0;
        

        while(k-->0){
            while(i<profits.length  && ls[i][0]<=w){
                pq.add(ls[i][1]);
                i++;
            }
            if(pq.size()==0){
                break;
            }
            w+=pq.poll();
            
        }
        return w;
    }
}