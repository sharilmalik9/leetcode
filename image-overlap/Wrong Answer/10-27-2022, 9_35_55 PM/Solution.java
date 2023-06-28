// https://leetcode.com/problems/image-overlap

class Solution {

private int shiftRightDown(int[][] A, int[][] B, int xShift, int yShift, int len){
    int count = 0;
    
    for(int i = yShift; i < len; i++){
        for(int j = xShift; j <len; j++){
            if(A[i][j] == 1 && B[i - yShift][j - xShift] == 1)
                count++;
        }
    }
    
    return count;
}

private int shiftRightUp(int[][] A, int[][] B, int xShift, int yShift, int len){
    int count = 0;
    
    for(int i = yShift; i < len; i++){
        for(int j = 0; j < len - xShift; j++){
            if(A[i][j] == 1 && B[i - yShift][j + xShift] == 1){
                count ++;
            }
        }
    }
    
    return count;
}

public int largestOverlap(int[][] img1, int[][] img2) {
    int maxCount = 0;
    int len = img1.length;
    
    for(int i = 0; i < len; i++){
        for(int j = 0; j < len; j++){
            maxCount = Math.max(maxCount, shiftRightDown(img1, img2, j, i, len));
            maxCount = Math.max(maxCount, shiftRightDown(img2, img1, j, i, len));
            maxCount = Math.max(maxCount, shiftRightUp(img1, img2, j, i, len));
            maxCount = Math.max(maxCount, shiftRightDown(img2, img1, j, i, len));
        }   
    }
    
    return maxCount;
}
}