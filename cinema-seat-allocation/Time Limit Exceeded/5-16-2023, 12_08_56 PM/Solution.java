// https://leetcode.com/problems/cinema-seat-allocation

class Solution {
    public int maxNumberOfFamilies(int n, int[][] r) {
        HashMap<Integer,HashSet<Integer>> hm= new HashMap<>();
        for(int[] i:r){
            if(hm.containsKey(i[0])){
                hm.get(i[0]).add(i[1]);
            }
            else{
                HashSet<Integer> hs= new HashSet<>();
                hs.add(i[1]);
                hm.put(i[0],hs);
            }
        }
        int ans=0;
        HashSet<Integer> hs;
        for(int i=1;i<=n;i++){
            int curr=0;
            if(!hm.containsKey(i)){
                ans+=2;
                continue;
            }
            hs=hm.get(i);
          if(!hs.contains(2) && !hs.contains(3)){
                if(!hs.contains(4) && !hs.contains(5)){
                    curr++;
                }
            }
           if(!hs.contains(8) && !hs.contains(9)){
               if(!hs.contains(6) && !hs.contains(7)){
                   curr++;
               }
           }
           if(curr==2 || curr==1){
               ans+=curr;
               continue;
           }
           if(!hs.contains(4) && !hs.contains(5) && !hs.contains(6) && !hs.contains(7)){
               ans+=1;
           } 

        }
         return ans; 
    }
}