// https://leetcode.com/problems/utf-8-validation

// dont even know the question 

class Solution {
    public boolean validUtf8(int[] data) {
		// Create precomputed arrays with the mask and prefixes.
		// Bitwise representation: [ [10000000,00000000],
		//                           [11100000,11000000],
		//                           [11110000,11100000],
		//                           [11111000,11110000]]
        int[][] headers = new int[][]{{128,0},{224,192},{240,224},{248,240}};
		
		// Bitwise representation: [11000000,10000000]
        int[] tail = new int[]{192,128};
        
        for(int i = 0; i < data.length; ++i){
			// Find which header matches
            int num = -1;
            for(int j = 0; j < 4; ++j){
                if((data[i]&headers[j][0])==headers[j][1]){
                    num=j;
                    break;
                }
            }
			// No match or there isn't enough data left
            if(num==-1 || i+num>=data.length)
                return false;
            
			// Check the remaining tail bytes
            for(int j = 0; j < num; ++j){
                if((data[++i]&tail[0])!=tail[1])
                    return false;
            }
        }
        
        return true;
    }
}