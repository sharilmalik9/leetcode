// https://leetcode.com/problems/game-of-life

class Solution {
    public void gameOfLife(int[][] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                int count = 0;
                if(j != a[0].length-1) {
                    if(a[i][j+1] % 100 == 1)
                        count++;
                }
                if(j != a[0].length-1 && i != a.length-1) {
                    if(a[i+1][j+1] % 100 == 1)
                        count++;
                }
                if(i != a.length-1) {
                    if(a[i+1][j] % 100 == 1)
                        count++;
                }
                if(j != 0 && i != a.length-1) {
                    if(a[i+1][j-1] % 100 == 1)
                        count++;
                }
                if(j != 0) {
                    if(a[i][j-1] % 100 == 1)
                        count++;
                }
                if(j != 0 && i != 0) {
                    if(a[i-1][j-1] % 100 == 1)
                        count++;
                }
                if(i != 0) {
                    if(a[i-1][j] % 100 == 1)
                        count++;
                }
                if(j != a[0].length-1 && i != 0) {
                    if(a[i-1][j+1] % 100 == 1)
                        count++;
                }
                if(a[i][j] == 1 && (count < 2 || count > 3))
                    a[i][j] = 101;
                else if(a[i][j] == 0 && count == 3)
                    a[i][j] = 100;
            }
        }
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                if(a[i][j] == 101)
                    a[i][j] = 0;
                else if(a[i][j] == 100)
                    a[i][j] = 1;
            }
        }
    }
}