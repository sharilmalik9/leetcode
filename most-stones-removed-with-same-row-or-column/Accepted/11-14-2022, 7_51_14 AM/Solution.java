// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column

class Solution {
    int[] parent = new int[20003];
    public int removeStones(int[][] stones) {
        for(int i=0;i<20003;i++) {
            parent[i] = i;
        }
        for(int i=0;i<stones.length;i++) {
            union(stones[i][0], 10000+ stones[i][1]);
        }
        
        Set<Integer> hs = new HashSet<>();
        for(int i=0;i<stones.length;i++) {
            hs.add(find(stones[i][0]));
        }
        
        return stones.length - hs.size();
    }
    
    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if(a!=b) {
            parent[a] = b;
        }
    }
    
    public int find(int x) {
        if(parent[x]==x) return x;
        
        return parent[x] = find(parent[x]);
        }
}