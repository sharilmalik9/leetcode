// https://leetcode.com/problems/roman-to-integer

class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char[] ch=s.toCharArray();
       
       int j=0;
       int ans=0;
       while(j<ch.length-1){
           if( map.get(ch[j]) < map.get(ch[j+1])){
               ans+=map.get(ch[j+1])-map.get(ch[j]);
               j+=2;
           }else{
               ans+=map.get(ch[j]);    
               j++;
           }
        
       }
       if(j==ch.length-1) ans+=map.get(ch[j]);
       return ans;
    }
}