// https://leetcode.com/problems/cheapest-flights-within-k-stops

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
        for(int[] f : flights){
            map.computeIfAbsent(f[0],m->new HashMap<>()).put(f[1],f[2]);
        }
        k++;
        int min = Integer.MAX_VALUE; 
        int[] count = new int[n];
        count[src]++; 
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src,0});
        while(!queue.isEmpty()){
            int size = queue.size();
            if(k--==0) break;
            while(size-->0){
                int[] cur = queue.poll();
                Map<Integer,Integer> next = map.getOrDefault(cur[0],null);
                if(next==null) continue;
                for(Map.Entry<Integer,Integer> entry : next.entrySet()){
                    if(cur[1] + entry.getValue() >= min) continue;
                    if(entry.getKey()==dst){
                        min = Math.min(min,cur[1] + entry.getValue());
                        continue;
                    } 
                    if(count[entry.getKey()]++<=n){
                        queue.add(new int[]{entry.getKey(),cur[1] + entry.getValue()});    
                    }       
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}