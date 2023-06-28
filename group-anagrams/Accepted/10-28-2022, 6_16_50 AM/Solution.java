// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String ,List<String>> hp= new HashMap<>();
        for(String str:strs){
            char[] str_arr = str.toCharArray();
            Arrays.sort(str_arr);
            String sorted_str = new String(str_arr);
            if(hp.containsKey(sorted_str)){
                hp.get(sorted_str).add(str);
            }
            else{
                hp.put(sorted_str,new ArrayList<String>());
                hp.get(sorted_str).add(str);
     
            }
}
        List<List<String>> ans= new ArrayList<>();
        ans.addAll(hp.values());
        return ans;
    }
}