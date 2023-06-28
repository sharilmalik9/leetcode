// https://leetcode.com/problems/string-without-aaa-or-bbb

class Solution { 
   
    List<String> ans=new ArrayList<>();
    public String strWithout3a3b(int a, int b) {
        rec(a,b,"",a+b);
        return ans.get(0);
    }
    public void rec(int a ,int b,String str,int len){
        if(str.length()==len){
            ans.add(str);
        }
        boolean is=true;
        if(a>0){
            if(str.length()>=2){
                if(str.charAt(str.length()-1)=='a' && str.charAt(str.length()-2)=='a'){
                   is=false;
                }
             }
             if(is){
                     rec(a-1,b,str+'a',len);
             }
            
        }
        is=true;
        if(b>0){
             if(str.length()>=2){
                if(str.charAt(str.length()-1)=='b' && str.charAt(str.length()-2)=='b'){
                    is=false;
                }
             }
             if(is){
                     rec(a,b-1,str+'b',len);
             }
            

        }
    }
}