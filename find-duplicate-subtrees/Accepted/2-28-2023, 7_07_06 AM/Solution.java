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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String,Pair> map = new HashMap();
        
        dfs(root,map);
        
        List<TreeNode> list = new ArrayList();
        for(String key : map.keySet()){
            Pair pair = map.get(key);
            if(pair.count>1) list.add(pair.node);
        }
        
        return list;
    }
    
    private String dfs(TreeNode node ,HashMap<String,Pair> map){
        if(node==null) return "N";
        
        String left = dfs(node.left,map);
        String right = dfs(node.right,map);
        
        String curr = node.val+"#"+left+"#"+right;
        
        if(map.containsKey(curr)){
            map.get(curr).count++;
        }else{
            map.put(curr,new Pair(node));
        }
        
        return curr;
    }
}

class Pair{
    TreeNode node;
    int count;
    
    public Pair(TreeNode node){
        this.node = node;
        this.count = 1;
    }
}