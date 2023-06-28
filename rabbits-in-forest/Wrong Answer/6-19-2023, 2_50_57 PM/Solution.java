// https://leetcode.com/problems/rabbits-in-forest

class Solution {
    public int numRabbits(int[] arr){
       HashMap<Integer,Integer> hm=new HashMap<>();
       for(int i=0;i<arr.length;i++){
           hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
       }
       int ans=0;
       for(int i:hm.keySet()){
           int total=hm.get(i);
           int suppose=i+1;

           if(total<=suppose){
               ans+=suppose;
           }
           if(total>suppose){
               ans+=(total%suppose)*suppose;
               ans+=(total/suppose)*suppose;
           }
          
       }
       return ans; 
    }
}