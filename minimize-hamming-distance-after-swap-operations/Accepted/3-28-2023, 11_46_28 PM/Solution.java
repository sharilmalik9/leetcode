// https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] swaps) {
        int length = source.length, minDistance = 0;
        int[] parent = new int[length];
        Arrays.fill(parent, -1);
        
        for(int i = 0; i < swaps.length; i++) {
            int x = find(parent, swaps[i][0]);
            int y = find(parent, swaps[i][1]);
            if(x != y) union(parent, x, y);
        }
        
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for(int i = 0; i < length; i++) {
            int val = source[i];
            int root = find(parent, i);
            
            map.putIfAbsent(root, new HashMap<>());
            HashMap<Integer, Integer> count = map.get(root);
            count.put(val, count.getOrDefault(val, 0)+1);
        }
        
        for(int i = 0; i < length; i++) {
            int val = target[i];
            int root = find(parent, i);
            
            HashMap<Integer, Integer> count = map.get(root);
            if(count.getOrDefault(val, 0) == 0) {
                minDistance++;
            } else {
                count.put(val, count.getOrDefault(val,0)-1);
            }
        }
        
        return minDistance;
    }
    
    private int find(int[] parent, int key) {
        if(parent[key] == -1) return key;
        return find(parent, parent[key]); 
    }
    
    private void union(int[] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[ySet] = xSet;
    }
}