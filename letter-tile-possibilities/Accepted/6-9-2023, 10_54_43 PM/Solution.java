// https://leetcode.com/problems/letter-tile-possibilities

class Solution {
    public int numTilePossibilities(String tiles) {
        int count[] = new int[26];
        for(int i = 0; i < tiles.length(); i++) {
            int index = tiles.charAt(i) - 'A';
            count[index]++;
        }
        return dfs(count);
    }

    private int dfs(int count[]) {
        int sum = 0;
        for(int i = 0; i < count.length; i++) {
            if(count[i] == 0) {
                continue;
            }
            sum++;
            
            count[i]--;
            sum += dfs(count);
            count[i]++;
        }
        return sum;
    }
}