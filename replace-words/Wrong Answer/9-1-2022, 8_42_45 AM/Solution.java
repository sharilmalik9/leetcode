// https://leetcode.com/problems/replace-words

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        HashSet<String> hs= new HashSet<>();
        for(int i=0;i<dictionary.size();i++){
            hs.add(dictionary.get(i));   
}
        List<String> arr= new ArrayList<>();
        for(String i:words){
            String ans="";
            boolean added=false;
            for(int j=0;j<i.length();j++){
                ans+=i.charAt(j);
                if(hs.contains(ans)){
                    arr.add(ans);
                    added=true;
                    continue;
                    
                    
                 }
               
             }
            if(!added){
                 arr.add(ans);
            }
         
            
            
}
        String ansf="";
        ansf+=arr.get(0);
        for(int i=1;i<arr.size();i++){
            ansf+=" ";
            ansf+=arr.get(i);
            
            
        }
        
        
        
        
        
        return ansf;
    }
}