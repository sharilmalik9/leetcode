// https://leetcode.com/problems/push-dominoes

class Solution {
    public String pushDominoes(String d) {
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<d.length();i++){
            if(d.charAt(i)=='.'){
                int idxr=i;
                int idxl=i;
                while(idxr>=0){
                    if(d.charAt(idxr)=='R'){
                        break;
                    }
                    else{
                        idxr--;
                    }
                  }
                while(idxl<d.length()){
                    if(d.charAt(idxl)=='L'){
                        break;
                    }
                    else{
                        idxl++;
                        
                    }
                }
              if((idxl-i)-(i-idxr)==0){
                  sb.append('.');
                  continue;
                  
              }
              else if(i-idxr<idxl-i){
                  sb.append('R');
              }
                else{
                    sb.append('L');
                }
                
                
                
                
                
            }
            else {
                sb.append(d.charAt(i));
            }
            
        }
        return sb.toString();
        
    }
}