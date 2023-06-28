// https://leetcode.com/problems/rotate-image

class Solution {
    public void rotate(int[][] matrix) {
         List<Integer> res = spiralOrder(matrix);
         if(matrix.length==0){
             return;
         }

        int idx=0;
        
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        
        while(true){
            for(int i = top; i <= bottom; i++) 
            {matrix[i][right]=res.get(idx);
            idx++;
            }
            right--;
         
            if(left > right || top > bottom) break;
            
            for(int i = right; i >= left; i--) {
            matrix[bottom][i]=res.get(idx);
            idx++;
            }
            bottom--;
          
            if(left > right || top > bottom) break;
            
            for(int i = bottom; i >= top; i--) {
            matrix[i][left]=res.get(idx);
            idx++;
            }
            left++;
          
            if(left > right || top > bottom) break;
            for(int i = left; i <= right; i++) {
            matrix[top][i]=res.get(idx);
            idx++;
            }
            top++;
            if(left > right || top > bottom) break;
        }
     
    }
   
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix[0].length == 0) return res;
        
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        
        while(true){
            for(int i = left; i <= right; i++) res.add(matrix[top][i]);
            top++;
            if(left > right || top > bottom) break;
            
            for(int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            right--;
            if(left > right || top > bottom) break;
            
            for(int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            bottom--;
            if(left > right || top > bottom) break;
            
            for(int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            left++;
            if(left > right || top > bottom) break;
        }
        
        return res;
    }
    


}