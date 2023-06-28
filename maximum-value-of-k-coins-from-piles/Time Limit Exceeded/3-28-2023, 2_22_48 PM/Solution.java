// https://leetcode.com/problems/maximum-value-of-k-coins-from-piles

class Solution {
    int ans=0;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
       rec(piles,0,k);
       return ans;
        
    }
    public void rec(List<List<Integer>> piles,int points,int k ){
        if(k==0){
            ans=Math.max(ans,points);
            return ;
        }
        int ans=0;
        for(int i=0;i<piles.size();i++){
            if(piles.get(i).size()==0){
                continue;
            }
            int ele=piles.get(i).get(0);
            piles.get(i).remove(0);
           rec(piles,points+ele,k-1);
            piles.get(i).add(0,ele);
            

            
        }
         

    }
}