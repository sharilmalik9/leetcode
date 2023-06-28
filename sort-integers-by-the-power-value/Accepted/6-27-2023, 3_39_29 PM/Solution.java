// https://leetcode.com/problems/sort-integers-by-the-power-value

class Solution {
    public int getKth(int lo, int hi, int k) {
       HashMap<Integer,Integer> hm=new HashMap<>();
      hm.put(1,0);
     PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> a[1]==b[1] ? a[0]-b[0] : a[1]-b[1]);
       for(int i=lo;i<=hi;i++){
           int hehe=help(i,hm);
           pq.add(new int[]{i,hehe});
          
       }
       int ans=-1;
       while(k-->0){
           ans=pq.poll()[0];
       }
       return ans;
       
       
     
    }
    public int help(int ele,HashMap<Integer,Integer> hm){
        if(ele==1){
            return 0;
        }
        if(hm.containsKey(ele)){
            return hm.get(ele);
        }
        int ans=0;
        if(ele%2==0){
            ans=help(ele/2,hm)+1;
        }

        else{
            ans=help(3*ele+1,hm)+1;
        }
        hm.put(ele,ans);

        return ans;
    }
}