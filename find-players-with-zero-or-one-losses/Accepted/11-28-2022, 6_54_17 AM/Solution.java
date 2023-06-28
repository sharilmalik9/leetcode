// https://leetcode.com/problems/find-players-with-zero-or-one-losses

class Solution {
    public List<List<Integer>> findWinners(int[][] matches){
       HashSet<Integer> all=new HashSet<>();
       
        HashMap<Integer,Integer> loss=new HashMap<>();
        for(int i=0;i<matches.length;i++){
            int winner=matches[i][0];
            int losser=matches[i][1];
            if(!all.contains(winner)){
                all.add(winner);
            }
            if(!all.contains(losser)){
                all.add(losser);
            }
           
            loss.put(losser,loss.getOrDefault(losser,0)+1);
}
        List<Integer> ls=new ArrayList<>();
        List<Integer> arr= new ArrayList<>();
        for(Integer i: all){
            if(loss.containsKey(i)){
                if(loss.get(i)==1){
                    arr.add(i);
                }
            }
            if(!loss.containsKey(i)){
                ls.add(i);
            }
        }
        List<List<Integer>> ans= new ArrayList<>();
        Collections.sort(ls);
        Collections.sort(arr);
        ans.add(ls);
        ans.add(arr);
        return ans;
        }
}