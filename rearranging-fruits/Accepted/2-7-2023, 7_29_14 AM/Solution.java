// https://leetcode.com/problems/rearranging-fruits

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer,Integer> hm= new HashMap<>();
        for(int c: basket1){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
         for(int c: basket2){
            hm.put(c,hm.getOrDefault(c,0)-1);
        }
        List<Integer> last= new ArrayList<>();
        for(Map.Entry<Integer,Integer> e: hm.entrySet()){
            int v=e.getValue();
            if(v%2!=0){
                return -1;
            }
            for(int i=0;i<Math.abs(v)/2;i++){
                last.add(e.getKey());
            }
        }
        int min=Math.min(Arrays.stream(basket1).min().getAsInt(),Arrays.stream(basket2).min().getAsInt());
        Collections.sort(last);
        long res=0;
        for(int i=0;i<last.size()/2;i++){
        res+=Math.min(last.get(i),2*min);
        }
        return res;
        
    }
}