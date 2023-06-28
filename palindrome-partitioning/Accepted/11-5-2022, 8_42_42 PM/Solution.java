// https://leetcode.com/problems/palindrome-partitioning

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        fcb(s,lists,new ArrayList<>(), 0); 
        return lists;
    }
    
    private void fcb(String s, List<List<String>> lists, ArrayList<String> list, int start) {
        if (start == s.length()){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); ++i) {
            if (isPalindrome(s, start, i)){
                list.add(s.substring(start,i+1));
                fcb(s,lists,list,i+1);
                list.remove(list.size() -1);
            }
        }
    }

    private boolean isPalindrome(String substring,int start , int end) {
        while (end >= start){
            if (substring.charAt(end) != substring.charAt(start)){
               return false;
            }
            end--;
            start++;
        }
        return true;
    }
}