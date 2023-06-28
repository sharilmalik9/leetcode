// https://leetcode.com/problems/lexicographically-smallest-equivalent-string

class Solution {
    int[] parent=new int[26];
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for(int i=0;i<26;i++){
            parent[i]=i;
        }
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)-'a'>s2.charAt(i)-'a'){
                union(s2.charAt(i)-'a',s1.charAt(i)-'a');

            }
            else{
                   union(s1.charAt(i)-'a',s2.charAt(i)-'a');
            }

        }
        System.out.println(Arrays.toString(parent));
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<baseStr.length();i++){
            sb.append((char)(parent(baseStr.charAt(i)-'a')+'a'));
        }
        return sb.toString();
    }
    public int parent(int element){
        if(parent[element]==element){
            return element;
        }
        return parent(parent[element]);
    }
    public void union(int ele1,int ele2){
        int parent1=parent(ele1);
         int parent2=parent(ele2);
        if(parent1==parent2){
            return ;
        }
        if(parent1>parent2){
            parent[parent1]=parent2;
        }
        else{
            parent[parent2]=parent1;
        }
        
    }
}