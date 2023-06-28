// https://leetcode.com/problems/number-of-operations-to-make-network-connected

class Solution {
    public int makeConnected(int n, int[][] connections) {
        List<List<Integer>> neigh= new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> curr= new ArrayList<>();
            neigh.add(i,curr);
        }
        
        int[] freq=new int[n];
        for(int i=0;i<connections.length;i++){
            int first=connections[i][0];
            int second= connections[i][1];
            neigh.get(first).add(second);
            neigh.get(second).add(first);
            freq[first]+=1;
            freq[second]+=1;
            
        }
        int needed=0;
       
        for(int i=0;i<n;i++){
            if(freq[i]==0){
                needed++;
            }
            
        }
        int ans=needed;
        int idx=0;
        while(idx<n && needed>0){
            if(freq[idx]>1){
                for(int i:neigh.get(idx)){
                    if(freq[i]>1){
                        needed--;
                        neigh.get(idx).remove(i);
                        freq[idx]-=1;
                        freq[i]-=1;
                        neigh.get(i).remove(idx);
                        
                    }
                }
            }
        }
        if(needed==0){
            return ans; 
        }
        else{
            return -1;
            
        }
        
    }
}