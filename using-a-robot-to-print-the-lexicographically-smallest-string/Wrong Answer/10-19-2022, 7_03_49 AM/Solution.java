// https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string

class Solution {
    public String robotWithString(String s){
        char[] arr= new char[s.length()];
        arr[s.length()-1]=s.charAt(s.length()-1);
        for(int i=s.length()-2;i>=0;i--){
            if(s.charAt(i)-'0'<arr[i+1]-'0'){
                arr[i]=s.charAt(i);
            }
            else{
                arr[i]=arr[i+1];
            }
        }
        System.out.println(Arrays.toString(arr));
        StringBuilder sb= new StringBuilder("");
         int start=0;
          int end=0;
       for(int i=1;i<s.length();i++){
           if(arr[i]==arr[i-1]){
               end++;
           }
           else{
               StringBuilder sbf=new StringBuilder(s.substring(start,end+1));  
               System.out.println(s.substring(start,end+1));
               sbf.reverse();  
               sb.append(sbf);
               start=i;
               end=i;
           }
          
                                     
       }
         StringBuilder sbf=new StringBuilder(s.substring(start,end+1));  
               System.out.println(s.substring(start,end+1));
               sbf.reverse();  
               sb.append(sbf);
              
      
       
        return sb.toString();
        
    }
}