// https://leetcode.com/problems/basic-calculator-ii

class Solution {
    public int calculate(String s){
        List<Integer> ls= new ArrayList<>();
       int i=0;
        while(i<s.length()){
           Character ch=s.charAt(i);
            if(Character.isDigit(ch)){
                int no=0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    no=no*10+(s.charAt(i)-'0');
                    i++;
                }
                ls.add(no);
                continue;
            }
            else if(ch==' '){
                i++;
                continue;
            }
            else if(ch=='+' || ch=='-'){
                if(ch=='+'){
                    ls.add(-1);
                }
                else{
                    ls.add(-2);
                }
                i++;
                continue;
            }
            else{
                i++;
                int no=0;
                 while(i<s.length() && Character.isDigit(s.charAt(i))){
                    no=no*10+(s.charAt(i)-'0');
                    i++;
                }
                 int no2=ls.remove(ls.size()-1);
             
                if(ch=='*'){
                    ls.add(no*no2);
                }
                else{
                    ls.add(no2/no);
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        i=0;
       for( ;i<ls.size();i++){
           if(ls.get(i)>=0){
               ans.add(ls.get(i));
           }
           else{
               int no1=ans.remove(ans.size()-1);
               int no2=ls.get(i+1);
               if(ls.get(i)==-1){
                   ans.add(no1+no2);
               }
               else{
                   ans.add(no1-no2);
               }
               i++;
           }
       }
        System.out.println(ans);
        return ans.get(0);
        
    }
}