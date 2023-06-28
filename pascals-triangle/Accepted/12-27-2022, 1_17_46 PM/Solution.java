// https://leetcode.com/problems/pascals-triangle

class Solution {
    public List<List<Integer>> generate(int r) {
     List<List<Integer>> ls= new ArrayList<>();
     if(r==0){
        return ls;
     }
     List<Integer> r1=new ArrayList<>();
     r1.add(1);
     ls.add(r1);
     for(int i=1;i<r;i++){
      List<Integer> l1=new ArrayList<>();
       l1.add(1);
      for(int j=1;j<i;j++){
       l1.add(ls.get(i-1).get(j-1)+ls.get(i-1).get(j));
       }
       l1.add(1);
        ls.add(l1);
      }
     return ls;  
    }
}
