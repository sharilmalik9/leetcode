// https://leetcode.com/problems/mice-and-cheese

class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int[][] r1 = new int[n][2];
        // storing the indices along with the differences
        // because we'll need to fetch the reward using the indices
        // from the two given arrays
        for (int i = 0; i < n; i++) {
            r1[i] = new int[] {reward1[i] - reward2[i], i};
        }
        
        // sort on the basis of difference (in descending order)
        Arrays.sort(r1, (a, b) -> b[0] - a[0]);
        int reward = 0;
        
        // feed the first top 'k' rewarding cheese to the first mouse
        for (int i = 0; i < k; i++) {
            reward += reward1[r1[i][1]];
        }
        // feed the leftover to the second mouse
        for (int i = k; i < n; i++) {
            reward += reward2[r1[i][1]];
        }
        
        return reward;
    }
}