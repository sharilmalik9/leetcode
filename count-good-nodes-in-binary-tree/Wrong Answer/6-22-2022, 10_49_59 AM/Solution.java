// https://leetcode.com/problems/count-good-nodes-in-binary-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
         String sb = "";
    ArrayList<String> result = new ArrayList<String>();
    helper(root, result, sb);
    return result.size();
        
    }
    public  int convertStringToInt(String input) {
        // Write your code here
        if (input.length() == 0) {
            return 0;
        }
        // Ascii value of '0' is 48, therefore to get the integer value of 48 we
        // subtract by 48.
        int n = input.charAt(0) - 48;

        for (int i = 0; i < input.length() - 1; i++) {
            n *= 10;
        }

        return n + convertStringToInt(input.substring(1));
    }

    public  boolean checkString(String str) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-') {
                arr1.add(i);
            }
        }
        int pos = 0;
        ArrayList<Integer> arr2 = new ArrayList<>();

        for (int i = 0; i < arr1.size(); i++) {
            String str1 = str.substring(pos, arr1.get(i));
            pos = arr1.get(i) + 1;
            arr2.add(convertStringToInt(str1));
        }
        arr2.add(convertStringToInt(str.substring(pos)));
        // System.out.println(arr2);

        int x = arr2.get(arr2.size() - 1);

        for (int i = 0; i < arr2.size() - 1; i++) {
            if (arr2.get(i) > x) {
                return false;
            }
        }

        return true;
    }
    public void helper(TreeNode root, ArrayList<String> result, String s){
    if(root==null){
        return;
    }
 
    s = s+"-"+root.val;
       // System.out.println(s);
   System.out.println(s);
    if(checkString(s)){
            System.out.println(s);
        
        result.add(s);
    }
 
   
 
    if(root.left!=null){
        helper(root.left, result, s);
    }
    if(root.right!=null){
        helper(root.right, result, s);
    }
    }
}