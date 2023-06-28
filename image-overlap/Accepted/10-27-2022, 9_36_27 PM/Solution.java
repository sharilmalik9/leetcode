// https://leetcode.com/problems/image-overlap

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<Pair> pairs1 = new ArrayList<>();
        for (int i = 0; i < img1.length; i++) {
            for (int j = 0; j < img1[0].length; j++) {
                if (img1[i][j] == 1) {
                    pairs1.add(new Pair(i, j));
                }
            }
        }
        
        int overlaps = 0;
        for (int i = 1 - img1.length; i < img1.length; i++) {
            for (int j = 1 - img1[0].length; j < img1[0].length; j++) {
                int tempOverlaps = 0;
                for (Pair pair : pairs1) {
                    int y = pair.y + i, x = pair.x + j;
                    if (cellExists(y, x, img2) && img2[y][x] == 1) {
                        tempOverlaps++;
                    }
                }
                overlaps = Math.max(tempOverlaps, overlaps);
            }
        }
        return overlaps;
    }

    private boolean cellExists(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    class Pair {
        int x;
        int y;

        public Pair(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}