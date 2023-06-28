// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree

class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] freq = new int[10];
        int[] res = new int[1];
        f(root, freq, res);
        return res[0];
    }
    private void f(TreeNode root, int[] freq, int[] res){
        if(root == null) return;
        
        if(isLeaf(root)){
            freq[root.val]++;
            if(pathIsPalindrome(freq)){
                res[0]++;
            }
            freq[root.val]--;
            return;
        }
        
        freq[root.val]++;;
        f(root.left, freq, res);
        f(root.right, freq, res);
        freq[root.val]--;   
        
    }
    private boolean isLeaf(TreeNode root){
        if(root.left == null && root.right == null) return true;
        else return false;
    }
    private boolean pathIsPalindrome(int[] freq){
        int odd = 0;
        for(int i : freq){
            if(i % 2 != 0) odd++;
        }
        if(odd > 1){
            return false;
        }else{
            return true;
        }
    }
}