// https://leetcode.com/problems/satisfiability-of-equality-equations

class Solution {
    public boolean equationsPossible(String[] equations) {
        
        HashMap<Character,Character> equal= new HashMap<>();
        HashMap<Character,Character> notequal=new HashMap<>();
        if(equations[0].charAt(1)=='!'){
            notequal.put(equations[0].charAt(0),equations[0].charAt(3));
        }
        else{
            notequal.put(equations[0].charAt(0),equations[0].charAt(3));
        }
        for(int i=0;i<equations.length;i++){
            char str1=equations[i].charAt(0);
            char str2=equations[i].charAt(3);
            char type=equations[i].charAt(1);
            if(type=='!'){
                if(equal.containsKey(str1)){
                    if(equal.get(str1)==str2){
                        return false;
                    }
                }
                else if(equal.containsKey(str2)){
                        if(equal.get(str2)==str1){
                            return false;
                        }
                    }
                    
                 else{
                     notequal.put(str1,str2);
                      
                  }  
                   
            }
            else{
                if(notequal.containsKey(str1)){
                    if(notequal.get(str1)==str2){
                        return false;
                    }
                }
                else if(notequal.containsKey(str2)){
                        if(notequal.get(str2)==str1){
                            return false;
                        }
                    }
                    
                 else{
                     equal.put(str1,str2);
                      
                  }  
                   
            }
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
            }
            
            
            
            
            
            
            
            
            
            
            
            
            
                
        
        
        
        
        
        
    return true;
        
        
        
    }
}