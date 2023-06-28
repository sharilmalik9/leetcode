// https://leetcode.com/problems/fruit-into-baskets

class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> hm= new HashMap<>();
        int i=0;
        int j=0;
        int ans=0;
        while( j<fruits.length){
            hm.put(fruits[j],hm.getOrDefault(fruits[j],0)+1);
            if(hm.size()>2){
                while(hm.size()>2){
                    hm.put(fruits[i],hm.get(fruits[i])-1);
                    if(hm.get(fruits[i])==0){
                        hm.remove(fruits[i]);
                    }
                    i++;
                }
            }
            else{
                ans=Math.max(ans,j-i+1);

            }
            
            j++;
        }
        return ans;
    }
}