// https://leetcode.com/problems/maximum-performance-of-a-team

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] nn= new int[speed.length][2];
        for(int i=0;i<speed.length;i++){
            
            nn[i][0]= efficiency[i];
            nn[i][1]=speed[i];
            
        }
        Arrays.sort(nn,(a,b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int sum=0;
        int max=0;
        for(int[] arr:nn){
            sum+=arr[1];
            pq.add(arr[1]);
            if(pq.size()>k){
                sum-=pq.poll();
                    
                    max=Math.max(max,sum*arr[0]);
            }
        }
        
        
        
        return max;
        
    }
}