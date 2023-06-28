// https://leetcode.com/problems/cinema-seat-allocation

class Solution {
    public int maxNumberOfFamilies(int n, int[][] r) {
        Arrays.sort(r,(a,b) ->(a[0]==b[0] ? a[1]-b[1] : a[0]-b[0])
        );
        int ans=0;
        int idx=0;
        HashSet<Integer> hs;
        for(int i=1;i<=n;i++){
            hs= new HashSet<>();
            while( idx<r.length && r[idx][0]==i){
                hs.add(r[idx][1]);
                idx++;
            }
            int curr=0;
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