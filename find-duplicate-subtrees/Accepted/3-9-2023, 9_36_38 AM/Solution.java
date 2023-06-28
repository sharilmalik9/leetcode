// https://leetcode.com/problems/find-duplicate-subtrees

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
    class pair{
        int count;
        TreeNode head;
        public pair(TreeNode head,int count){
            this.head=head;
            this.count=count;
        }
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String,pair> hm= new HashMap<>();
        help(hm,root);
        List<TreeNode> list = new ArrayList();
        for(String key : hm.keySet()){
            pair pir = hm.get(key);
            if(pir.count>1) list.add(pir.head);
        }
        
        return list;

    }
    public String help(HashMap<String,pair> hm,TreeNode root){
        if(root==null){
            return "N";
        }
        String left=help(hm,root.left);
        String right=help(hm,root.right);
        String curr=root.val + "#" + left+"#"+ right;
        if(hm.containsKey(curr)){
            hm.get(curr).count++;

        }
        else{
            hm.put(curr,new pair(root,1));
        }
        return curr;
    }
}